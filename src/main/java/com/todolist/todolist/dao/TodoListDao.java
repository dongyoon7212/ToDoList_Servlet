package com.todolist.todolist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			pstmt.setInt(3, todoListVo.getTodoListComplete());
			
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
	
	public int updateTodo(TodoListVo todoListVo) {
		int successCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = pool.getConnection();
			String sql = "update todolist_tb set todolist_content = ?, todolist_complete = ? where todolist_id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, todoListVo.getTodoListContent());
			pstmt.setInt(2, todoListVo.getTodoListComplete());
			pstmt.setInt(3, todoListVo.getTodoListId());
			
			successCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		
		return successCount;
	}
	
	public List<TodoListVo> getTodoList() {
		List<TodoListVo> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			String sql = "select * from todolist_tb where todolist_complete = 0 order by todolist_id DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				TodoListVo todoListVo = TodoListVo.builder()
						.todoListId(rs.getInt(1))
						.todoListDate(rs.getString(2))
						.todoListContent(rs.getString(3))
						.todoListComplete(rs.getInt(4))
						.build();
				
				list.add(todoListVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return list;
	}
	
	public List<TodoListVo> getCompleteTodoList() {
		List<TodoListVo> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			String sql = "select * from todolist_tb where todolist_complete = 1 order by todolist_id DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				TodoListVo todoListVo = TodoListVo.builder()
						.todoListId(rs.getInt(1))
						.todoListDate(rs.getString(2))
						.todoListContent(rs.getString(3))
						.todoListComplete(rs.getInt(4))
						.build();
				
				list.add(todoListVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return list;
	}

}
