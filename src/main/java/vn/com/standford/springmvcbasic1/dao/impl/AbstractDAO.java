package vn.com.standford.springmvcbasic1.dao.impl;

import vn.com.standford.springmvcbasic1.dao.IGenericDAO;
import vn.com.standford.springmvcbasic1.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AbstractDAO<T> implements IGenericDAO<T> {
    //	ResourceBundle bundle = ResourceBundle.getBundle("db");
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/new_jdbc";
            String user = "root";
            String password = "Tuyen18072001";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (SQLException e) {
            return null;
        }

    }

    public <T> List<T> query(String sql, RowMapper<T> rowmapper, Object... Parameter) {
        List<T> results = new ArrayList<T>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            //set parameters
            setparameter(statement, Parameter);
            resultset = statement.executeQuery();
            while (resultset.next()) {
                results.add(rowmapper.mapRow(resultset));
            }

            return results;
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if (resultset != null) resultset.close();
            } catch (SQLException e) {
                return null;
            }
        }
    }

    private void setparameter(PreparedStatement statement, Object[] parameter) {
        int index = 0;
        try {
            for (Object para : parameter) {
                index++;
                statement.setObject(index, para);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
	/*private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/



	public void update(String sql, Object... Parameter) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            setparameter(statement, Parameter);
            statement.executeUpdate();
            connection.commit();
            return;
        } catch (Exception e) {
            if (connection != null)
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                return;
            }
        }
    }

    public Long insert(String sql, Object... Parameter) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Long id = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql, statement.RETURN_GENERATED_KEYS);
            setparameter(statement, Parameter);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }
            connection.commit();
            return id;
        } catch (Exception e) {
            if (connection != null)
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            return null;
        } finally {
            try {
                if (connection != null) connection.close();
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                return null;
            }
        }
    }

    public int count(String sql, Object... Parameter) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            int count = 0;
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setparameter(statement, Parameter);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            return 0;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                return 0;
            }
        }
    }
}
