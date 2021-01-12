package com.ShangShi;

public class Main {

    public abstract class Decorator extends TextView
    {
        public abstract String draw();
    }

    public class HorizontalScrollBar extends Decorator
    {
        TextView textview;
        public HorizontalScrollBar(TextView textview)
        {
            this.textview = textview;
        }
        public String draw()
        {
            return textview.draw() + " with horizontal scroll bar";
        }
    }

    public class VerticalScrollBar extends Decorator {
        TextView textview;
        public VerticalScrollBar(TextView textview)
        {
            this.textview = textview;
        }
        public String draw() {
            return textview.draw() + " with vertical scroll bar";
        }
    }

    public class TextViewMain {
        public static void main(String args[]) {
            TextView textview = new SimpleWindow();
            textview = new VerticalScrollBar(textview);
            textview = new HorizontalScrollBar(textview);
            System.out.println(textview.draw());
        }
    }
}
