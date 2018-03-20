package cn.jxufe.serviceImp.evaluation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServlet;

import cn.jxufe.dao.OpenEvaDao;
import cn.jxufe.dao.TEvaluaterDao;
import cn.jxufe.dao.vdao.VInfoDao;
import cn.jxufe.daoImp.OpenEvaDaoImp;
import cn.jxufe.daoImp.TEvaluaterDaoImp;
import cn.jxufe.daoImp.vdaoImp.VInfoDaoImp;
import cn.jxufe.domain.ventity.VInfo;
import cn.jxufe.service.evaluation.OpenEvaService;



/**
 * @author Administrator
 *互评算法
 */
public class TOpenEvaServiceImp implements OpenEvaService {

	/**
	 * @param unitId
	 *            班级号
	 * @param termNum
	 *            学期
	 * @param num
	 *            相互互评的人数
	 * @return true false 操作是否成功
	 */
	@Override
	public boolean evaStrategy(int unitId, int termNum, int num,String isSelf)  {

		// 首先判断是否开启过互评

		// 找到unitId班级名单

		VInfoDao vInfoDao = new VInfoDaoImp();

		int count=0;
		try {
			Collection<VInfo> vInfos = vInfoDao.findVInfosbyUnitId(unitId);

			Iterator<VInfo> it = vInfos.iterator();
			ArrayList<T1> t1 = new ArrayList<>();
			while (it.hasNext()) {
				T1 t = new T1(it.next().getUserId());
				t1.add(t);
			}

			for (int i = 0; i < t1.size(); i++) {
				if (t1.size() == 0) {
					System.out.println("异常");
					return false;
				}
				for (int j = 0; j < num; j++) {
					int x1 = (int) (Math.random() * t1.size());
					// 不为自己 不评同一人多次 不被评超过num次 不评超过num人 四个条件
					while (x1 == i | find(t1.get(i), x1)
							| t1.get(x1).behas >= num |count > num*t1.size()*10) {
						x1 = (int) (Math.random() * t1.size());
						count++;
					}
					// 将过滤出的加入ids,并将behas加1
					t1.get(i).ids.add(t1.get(x1).userId);
					t1.get(x1).behas++;
				}
			}
			// 输出，将结果插入数据库
			TEvaluaterDao tEvaluaterDao = new TEvaluaterDaoImp();
			for (int i = 0; i < t1.size(); i++) {
				System.out.print("评价人：" + t1.get(i).userId + " 被评价：");
				
				for (int j = 0; j < num; j++) {
					System.out.print(t1.get(i).ids.get(j) + " ");
					
					tEvaluaterDao.InsertTEvaluater(t1.get(i).ids.get(j)
							.intValue(), termNum, t1.get(i).userId);
				}
				//if(isSelf=="option1"){
					//自评插入
					tEvaluaterDao.InsertTEvaluater(t1.get(i).userId, termNum, t1.get(i).userId);
			//	}
				System.out.println();
			}
			OpenEvaDao openEvaDao=new OpenEvaDaoImp();
			openEvaDao.addOpenEva(unitId, termNum);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	// 去除同一人评判多次
	private boolean find(T1 t, int x1) {

		for (int start = 0; start < (t.ids.size()); start++) {
			if (t.ids.get(start) == x1) {
				return true;
			}
		}

		return false;
	}

	class T1 {
		public T1(int userId) {
			this.userId = userId;

			this.behas = 0;
		}

		int userId;
		ArrayList<Integer> ids = new ArrayList<>();
		int behas;
	}
}
