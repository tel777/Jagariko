package com.Ichif1205.jagariko;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class GraphicsView extends View {
	private int mColorId;

	public GraphicsView(Context context, int colorId) {
		super(context);
		this.mColorId = colorId;
	}

	// onDrawをオーバーライドして描画処理を作成する。
	@Override
	protected void onDraw(Canvas canvas) {
		// clear
		// canvas.drawColor(Color.WHITE);

		// Paintを定義(描画をする際のペン的なイメージでOK)
		Paint paint = new Paint();

		// 色セット
		paint.setColor(mColorId);
		//paint.setARGB(255, 87, 217, 158);
		// Viewの描画エリアはcanvasという名前になっているため、
		// ここにdwawCircleで点を描く
		// (円中心座標X、円中心座標Y、半径幅px)となります。
		// 数字fというのは、その数字をfloatで扱うという意味です。
		// 上記でも描画はできますが、なめらかな円ではないです。
		// そこで下記のアンチエイリアス(円滑化)をONにします。
		paint.setAntiAlias(true);

		canvas.drawCircle(300, 300, 50, paint);
	}

}
