package cn.jxufe.dao;

import cn.jxufe.domain.TFile;

import java.util.*;

public interface TFileDao {
	/**
	 * @author A
	 *	文件查找：fileId
	 *	文件的增加：fileId,fileName,fileUrl,fileComent
	 *	文件的删除：fileId
	 *	文件修改：fileId,fileName,fileUrl,fileComent
	 * @return 
	 */
	
	public boolean checkbyID(long fileId)throws Exception;
	public boolean InsertTFile(long fileId,String fileName,String fileUrl,String fileComent)throws Exception;
	public boolean DeletebyID(long fileId) throws Exception;
	public boolean UpdatebyID(long fileId,String fileName,String fileUrl,String fileComent)throws Exception;
	}