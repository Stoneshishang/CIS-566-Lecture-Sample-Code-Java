package com.ShangShi;

public class Main {
    public abstract class Handler
    {
        protected Handler successor;

        public void SetSuccessor(Handler successor)
        {
            this.successor = successor;
        }
        public abstract void handleRequest(Message msg);
    }

    public class SpamFilter extends Handler {

        public void handleRequest(Message msg)
        {
            if (isSpam(msg))
            { // take spam-related action. Do not forward message

            }
            else
            { // Pass message to the next handler
                if (successor != null) successor.handleRequest(msg)
            }
        }
    }

    public static void main() {
// Setup the chain
        Handler h1 = new SpamFilter();
        Handler h2 = new MessageHandler();
        h1.SetSuccessor(h2);
        h1.handleRequest(Message)
    }
}
