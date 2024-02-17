package com.todolist.todolist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.todolist.todolist.config.DBConnectionMgr;
import com.todolist.todolist.vo.TodoListVo;

public class TodoListDao {
	private static TodoListDao instance;
	private DBConnectionMgr pool;
	
	private TodoListDao() {
		pool = DBConnectionMgr.getInstance();
	}
	
	public static TodoListDao getInstance() {
		if( instance == null) {
			instance = new TodoListDao();
		}
		
		return instance;
	}
	
	public int saveTodo(TodoListVo todoListVo) {
		int successCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			String sql = "insert into todolist_tb values (0, ?, ?, ?)";
			pstmt = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, todoListVo.getTodoListDate());
			pstmt.setString(2, todoListVo.getTodoListContent());
			pstmt.setInt(3, todoListVo.getTodoListLike());
			
			successCount = pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				todoListVo.setTodoListId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return successCount;
	}
}
