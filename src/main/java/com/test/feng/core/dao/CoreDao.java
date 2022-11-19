package com.test.feng.core.dao;

import java.util.List;

public interface CoreDao<P, I> {
	List<P> selectAll();
}
