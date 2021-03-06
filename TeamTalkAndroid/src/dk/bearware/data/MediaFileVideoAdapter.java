/*
 * Copyright (c) 2005-2016, BearWare.dk
 * 
 * Contact Information:
 *
 * Bjoern D. Rasmussen
 * Skanderborgvej 40 4-2
 * DK-8000 Aarhus C
 * Denmark
 * Email: contact@bearware.dk
 * Phone: +45 20 20 54 59
 * Web: http://www.bearware.dk
 *
 * This source code is part of the TeamTalk 5 SDK owned by
 * BearWare.dk. All copyright statements may not be removed 
 * or altered from any source distribution. If you use this
 * software in a product, an acknowledgment in the product 
 * documentation is required.
 *
 */

package dk.bearware.data;

import java.nio.ByteBuffer;
import java.util.Vector;

import dk.bearware.DesktopInput;
import dk.bearware.MediaFileInfo;
import dk.bearware.User;
import dk.bearware.UserState;
import dk.bearware.VideoFrame;
import dk.bearware.backend.TeamTalkService;
import dk.bearware.events.UserListener;
import dk.bearware.gui.Utils;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

public class MediaFileVideoAdapter extends MediaAdapter 
implements UserListener {

    public static final String TAG = "bearware";

    public MediaFileVideoAdapter(Context context) {
        super(context);
    }

    public void setTeamTalkService(TeamTalkService service) {
        super.setTeamTalkService(service);
        
        service.registerUserListener(this);

        Vector<User> vecusers = Utils.getUsers(ttservice.getUsers());
        for(User user : vecusers) {
            if((user.uUserState & UserState.USERSTATE_MEDIAFILE_VIDEO) == UserState.USERSTATE_MEDIAFILE_VIDEO)
                display_users.put(user.nUserID, user);
        }
    }
    
    public void clearTeamTalkService(TeamTalkService service) {
        super.clearTeamTalkService(service);
        service.unregisterUserListener(this);
    }

    @Override
    public Bitmap extractUserBitmap(int userid, Bitmap prev_bmp) {
        VideoFrame wnd = ttservice.getTTInstance().acquireUserMediaVideoFrame(userid);
        
        if(wnd == null) {
            return null;
        }
        
        if(prev_bmp != null) {
            // create new bitmap if size 
            if(prev_bmp.getWidth() != wnd.nWidth || prev_bmp.getHeight() != wnd.nHeight)
                prev_bmp = Bitmap.createBitmap(wnd.nWidth, wnd.nHeight, Bitmap.Config.ARGB_8888);
        }
        else {
            prev_bmp = Bitmap.createBitmap(wnd.nWidth, wnd.nHeight, Bitmap.Config.ARGB_8888);
        }
        
        prev_bmp.copyPixelsFromBuffer(ByteBuffer.wrap(wnd.frameBuffer));
        
        return prev_bmp;
    }

    @Override
    public void onUserStateChange(User user) {
//    	this.updateUserStreamState(user, UserState.USERSTATE_MEDIAFILE_VIDEO);
        if((user.uUserState & UserState.USERSTATE_MEDIAFILE_VIDEO) == UserState.USERSTATE_MEDIAFILE_VIDEO)
            Log.d(TAG, "#" + user.nUserID + " video active");
        else
            Log.d(TAG, "#" + user.nUserID + " video inactive");
    }

    @Override
    public void onUserVideoCapture(int nUserID, int nStreamID) {
    }

    @Override
    public void onUserMediaFileVideo(int nUserID, int nStreamID) {
        //only update if user is expanded (bitmap is being displayed)
        if(media_sessions.indexOfKey(nUserID) >= 0)
            updateUserBitmap(nUserID);
        
        Log.d(TAG, "#" + nUserID + " video stream " + nStreamID);
    }

    @Override
    public void onUserDesktopWindow(int nUserID, int nStreamID) {
    }

    @Override
    public void onUserDesktopCursor(int nUserID, DesktopInput desktopinput) {
    }

    @Override
    public void onUserRecordMediaFile(int nUserID, MediaFileInfo mediafileinfo) {
    }

    @Override
    public void onUserAudioBlock(int nUserID, int nStreamType) {
    }

}
