/**
 * 
 */
package com.qduam.common.persistence;

import java.util.List;

/**
 * CrudDao create|read|update|delete
 * @author lilinzhen
 * @version 2018年3月4日
 */
public interface CrudDao<T> extends BaseDao {
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(int id);

	/**
	 * 查询数据列表（主要用在含有条件查询的场景）
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);
	
	/**
	 * 查询所有数据列表（一般用不到）
	 * @param entity
	 * @return
	 */
	public List<T> findAllList(T entity);
	
	/**
	 * 插入数据
	 * @param entity
	 * @return
	 */
	public int insert(T entity);
	
	/**
	 * 更新数据
	 * @param entity
	 * @return
	 */
	public int update(T entity);

	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	public int delete(int id);
	
}
