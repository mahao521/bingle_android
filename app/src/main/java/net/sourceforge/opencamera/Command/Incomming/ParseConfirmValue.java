package net.sourceforge.opencamera.Command.Incomming;

import android.util.Log;

import net.sourceforge.opencamera.Command.CommandAction;
import net.sourceforge.opencamera.Command.ICommand;
import net.sourceforge.opencamera.Data.Serial.ProtocolUtil;
import net.sourceforge.opencamera.Data.Serial.SBGCProtocol;

/**
 * Created by KIMSEONHO on 2015-11-17.
 * CMD_CONFIRM - confirmation of previous command
 */
public class ParseConfirmValue implements ICommand {

    /**
     * CMD - 1u, DATA - depends on CMD
     * Board sends confirmation on commands: A, G, P, W, etc.
     * DATA is empty unless mentioned in command description.
     *
     * need to be implement more as you want!
     * @param data
     * @return
     */
    @Override
    public boolean execute(byte[] data) {
        char val = ProtocolUtil.getConfirmValue(data);

        if (val == SBGCProtocol.CMD_MOTORS_OFF)
            Log.d(CommandAction.TAG, "CMD_CONFIRM: Motors OFF");
        else if (val == SBGCProtocol.CMD_MOTORS_ON)
            Log.d(CommandAction.TAG, "CMD_CONFIRM: Motors ON");
        else
            Log.d(CommandAction.TAG, "CMD_CONFIRM: " + val);

        return true;
    }
}
