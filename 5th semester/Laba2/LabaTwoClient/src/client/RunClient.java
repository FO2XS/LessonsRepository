package client;

import service.endpoint.MessageServiceService;

public class RunClient {
    public static void main (String[] argv)
    {
        try
        {
            MessageServiceService service = new MessageServiceService();
            System.out.println ("ws:" + service.getMessageServicePort().getMessage());
        }
        catch (Exception e)
        {
            System.out.println ("Message Client exception: " + e);
        }
    }
}

