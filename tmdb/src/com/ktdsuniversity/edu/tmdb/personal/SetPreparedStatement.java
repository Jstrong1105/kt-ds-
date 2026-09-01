package com.ktdsuniversity.edu.tmdb.personal;

import java.sql.PreparedStatement;

@FunctionalInterface
public interface SetPreparedStatement {

	void set(PreparedStatement pstmt);
}
