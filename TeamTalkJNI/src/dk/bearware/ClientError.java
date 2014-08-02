/*
 * Copyright (c) 2005-2014, BearWare.dk
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

package dk.bearware;

public class ClientError {

    public final int SUCCESS = 0;

    public final int CMDERR_SYNTAX_ERROR                     = 1000;
    public final int CMDERR_UNKNOWN_COMMAND                  = 1001;
    public final int CMDERR_MISSING_PARAMETER                = 1002;
    public final int CMDERR_INCOMPATIBLE_PROTOCOLS           = 1003;
    public final int CMDERR_UNKNOWN_AUDIOCODEC               = 1004;
    public final int CMDERR_INVALID_USERNAME                 = 1005;

    public final int CMDERR_INCORRECT_SERVER_PASSWORD        = 2000;
    public final int CMDERR_INCORRECT_CHANNEL_PASSWORD       = 2001;
    public final int CMDERR_INVALID_ACCOUNT                  = 2002;
    public final int CMDERR_MAX_SERVER_USERS_EXCEEDED        = 2003;
    public final int CMDERR_MAX_CHANNEL_USERS_EXCEEDED       = 2004;
    public final int CMDERR_SERVER_BANNED                    = 2005;
    public final int CMDERR_NOT_AUTHORIZED                   = 2006;
    public final int CMDERR_MAX_DISKUSAGE_EXCEEDED           = 2008;

    public final int CMDERR_INCORRECT_OP_PASSWORD            = 2010;
    public final int CMDERR_AUDIOCODEC_BITRATE_LIMIT_EXCEEDED = 2011;
    public final int CMDERR_MAX_LOGINS_PER_IPADDRESS_EXCEEDED = 2012;
    public final int CMDERR_MAX_CHANNELS_EXCEEDED            = 2013;

    public final int CMDERR_NOT_LOGGEDIN                     = 3000;
    public final int CMDERR_ALREADY_LOGGEDIN                 = 3001;
    public final int CMDERR_NOT_IN_CHANNEL                   = 3002;
    public final int CMDERR_ALREADY_IN_CHANNEL               = 3003;
    public final int CMDERR_CHANNEL_ALREADY_EXISTS           = 3004;
    public final int CMDERR_CHANNEL_NOT_FOUND                = 3005;
    public final int CMDERR_USER_NOT_FOUND                   = 3006;
    public final int CMDERR_BAN_NOT_FOUND                    = 3007;
    public final int CMDERR_FILETRANSFER_NOT_FOUND           = 3008;
    public final int CMDERR_OPENFILE_FAILED                  = 3009;
    public final int CMDERR_ACCOUNT_NOT_FOUND                = 3010;
    public final int CMDERR_FILE_NOT_FOUND                   = 3011;
    public final int CMDERR_FILE_ALREADY_EXISTS              = 3012;
    public final int CMDERR_FILESHARING_DISABLED             = 3013;
    public final int CMDERR_CHANNEL_HAS_USERS                = 3015;

    public final int PUBLIC FINAL INTERR_SNDINPUT_FAILURE                 = 10000;
    public final int PUBLIC FINAL INTERR_SNDOUTPUT_FAILURE                = 10001;
    public final int PUBLIC FINAL INTERR_AUDIOCODEC_INIT_FAILED           = 10002;
    public final int PUBLIC FINAL INTERR_AUDIOCONFIG_INIT_FAILED          = 10003;
}