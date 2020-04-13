class Point2 {
    private int x, y;
    
    public Point2() {
        this.x = 0;
        this.y = 0;
    }
    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
 }

 