using System;

namespace ServerObj
{
    public interface IRemoteTime
    {
        DateTime CurrentTime { get; }
    }
}
