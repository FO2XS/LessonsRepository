using System;

namespace ServerObj
{
    public class RemoteTime : MarshalByRefObject, IRemoteTime
    {
        public DateTime CurrentTime
        { 
            get { return DateTime.Now; } 
        }
    }
}
