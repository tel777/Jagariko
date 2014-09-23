package com.Ichif1205.jagariko;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "shibuya.db";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_COUNT = "count";
	public static final String COLUMN_LEVEL = "level";
	public static final String COLUMN_COMBO = "combo";
	public static final String COLUMN_TIME = "time";
	public static final String COLUMN_DATE = "date";
	public static final String SCORE_TABLE = "ranks_score";
	public static final String TIME_TABLE = "ranks_time";
	public static final String TABLE_NORMAL = "normal_table";
	public static final String TABLE_CHANGE = "change_table";
	public static final String TABLE_TIME = "time_table";

	private static final int DATABASE_VERSION = 1;

	public DatabaseOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// used normal
		db.execSQL("CREATE TABLE " + TABLE_NORMAL + " (" + COLUMN_ID
				+ " INTEGER PRIMARY KEY," + COLUMN_COUNT + " INTEGER,"
				+ COLUMN_LEVEL + " INTEGER," + COLUMN_COMBO + " INTEGER,"
				+ COLUMN_TIME + " INTEGER," + COLUMN_DATE + " INTEGER);");
		// used change
		db.execSQL("CREATE TABLE " + TABLE_CHANGE + " (" + COLUMN_ID
				+ " INTEGER PRIMARY KEY," + COLUMN_COUNT + " INTEGER,"
				+ COLUMN_LEVEL + " INTEGER," + COLUMN_COMBO + " INTEGER,"
				+ COLUMN_TIME + " INTEGER," + COLUMN_DATE + " INTEGER);");
		// used expert
		db.execSQL("CREATE TABLE " + TABLE_TIME + " (" + COLUMN_ID
				+ " INTEGER PRIMARY KEY," + COLUMN_COUNT + " INTEGER,"
				+ COLUMN_LEVEL + " INTEGER," + COLUMN_COMBO + " INTEGER,"
				+ COLUMN_TIME + " INTEGER," + COLUMN_DATE + " INTEGER);");

		// insert dummy data to ranks_score
		// String insertMe = "INSERT INTO " + SCORE_TABLE +
		// "("+ COLUMN_SCORE +", " + COLUMN_AVERAGE + ", " + COLUMN_DATE +
		// ") VALUES";
		// db.execSQL(insertMe + "(11111, 40.5, 1357896755);");
		// db.execSQL(insertMe + "(1234567, 20.5, 1357983155);");

		// insert dummy data to ranks_time
		// insertMe = "INSERT INTO " + TIME_TABLE +
		// "(" + COLUMN_AVERAGE + ", " + COLUMN_DATE + ") VALUES";
		// db.execSQL(insertMe + "(40.5, 1357896755);");
		// db.execSQL(insertMe + "(20.5, 1357983155);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
