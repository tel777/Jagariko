package com.Ichif1205.jagariko;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

public class Ranks {
//	expand table
//	private static final String[] RANK_QUERY_COLUMNS = {"_id", "score", "average", "date"};
	
	//
	private static final String[] RANK_QUERY_COLUMNS = {"_id", "average", "date"};
	public static final Uri CONTENT_URI_NORMAL = Uri.parse("content://com.Ichif1205.shibuya/"+DatabaseOpenHelper.TABLE_NORMAL);
	public static final Uri CONTENT_URI_CHANGE = Uri.parse("content://com.Ichif1205.shibuya/"+DatabaseOpenHelper.TABLE_CHANGE);
	public static final Uri CONTENT_URI_EXPERT = Uri.parse("content://com.Ichif1205.shibuya/"+DatabaseOpenHelper.TABLE_EXPERT);
			
	public static Cursor getRanksNormalCursor(ContentResolver contentResolver) {
		return contentResolver.query(CONTENT_URI_NORMAL, RANK_QUERY_COLUMNS, null, null, "average ASC" + " LIMIT 10");
	}
	public static Cursor getRanksChangeCursor(ContentResolver contentResolver) {
		return contentResolver.query(CONTENT_URI_CHANGE, RANK_QUERY_COLUMNS, null, null, "average ASC" + " LIMIT 10");
	}
	public static Cursor getRanksExpertCursor(ContentResolver contentResolver) {
		return contentResolver.query(CONTENT_URI_EXPERT, RANK_QUERY_COLUMNS, null, null, "average ASC" + " LIMIT 10");
	}
	
}
