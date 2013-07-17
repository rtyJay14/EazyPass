package com.android.eazypass.other;
/*package com.android.eazypass;
package com.example.android.sqlite.demo;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundManager {
	public static final int SUCCESS_SOUND = 1;
	public static final int ERROR_SOUND = 2;	
	private static SoundManager soundManager;
	
	private MediaPlayer mp;
	private Context context;
	
	private SoundManager(Context context) {	
		this.context = context;
	}
	
	// Singleton Implementation
	public static SoundManager getInstance(Context context) {
		if(soundManager == null) {
			soundManager =  new SoundManager(context);
		}
		
		return soundManager;
	}

	public void playSound(int tone) {
		if (mp != null) {
			mp.reset();
			mp.release();
		}
		
		if (tone == SUCCESS_SOUND) {
			mp = MediaPlayer.create(context, R.raw.hello);
		} else if (tone == ERROR_SOUND) {
			mp = MediaPlayer.create(context, R.raw.error);
		}

		mp.start();
	}
}
*/