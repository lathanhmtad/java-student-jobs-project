package com.example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.example.mapper.RowMapper;
import com.example.utils.JDBCUtil;

public class AbstractDAO<T> {

	private void setParams(PreparedStatement ps, Object... params) {
		for (int i = 0; i < params.length; i++) {
			try {
				if (params[i] instanceof Long) {
					ps.setLong(i + 1, (Long) params[i]);
				} else if (params[i] instanceof Date) {
					ps.setDate(i + 1, (Date) params[i]);
				} else if (params[i] instanceof String) {
					ps.setString(i + 1, (String) params[i]);
				} else if(params[i] instanceof Time) {
					ps.setTime(i + 1, (Time) params[i]);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<T> query(String sql, RowMapper<T> rowMapper, Object... params) {
		List<T> results = new ArrayList<>();
		try (Connection conn = JDBCUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			setParams(ps, params);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					T o = rowMapper.mapRow(rs);
					results.add(o);
				}
			}

			return results;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insert(String sql, Object... params) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);

			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				setParams(ps, params);
				ps.executeUpdate();

				conn.commit();
				return true;
			}

		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public boolean update(String sql, Object... params) {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);

			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				setParams(ps, params);
				ps.executeUpdate();
			}

			conn.commit();
			return true;

		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
