顺时针打印矩阵数 
思路：矩阵每循环一次，行数和列数都减少2个，设置一个start，若cols < 2* start 或者  rows > 2 * start说明矩阵已经循环结束。在这个循环过程中
往list中添加整数。需要设置每次循环中的终止行号endX和终止列号endY，需要用到cols, rows,start，list这四个参数。