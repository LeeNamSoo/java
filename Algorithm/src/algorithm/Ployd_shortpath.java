package algorithm;

class Ployd_shortpath {

	int[][] graph = { { 0, 1, 999, 1, 5 }, 
					  { 9, 0, 3, 2, 999 }, 
					  { 999, 999, 0, 4, 999 }, 
					  { 999, 999, 2, 0, 3 },
					  { 3, 999, 999, 999, 0 } };//±×·¡ÇÁ ³ëµåÀÇ ¿¬°á±­°è
	public Ployd_shortpath() {//°¢ ³ëµå¿¡¼­ ³ëµå·Î ¾Æµ¿ÇÏ´Âµ¥ °É¸®´Â ÃÖ¼Ò°¡ÁßÄ¡¸¦ ±¸ÇÏ´Â ÇÔ¼ö
		for (int i = 0; i < graph.length; i++) {//Áö³ª°¡´Â °æ·Î
			for (int j = 0; j < graph.length; j++) {//Ãâ¹ßÁöÁ¡
				for (int k = 0; k < graph.length; k++) {//µµÂøÁöÁ¡
					if (graph[j][k] > graph[j][i] + graph[i][k]) {//¹Ù·Î°¡´Â ±æº¸´Ù °ÅÃÄ°¡´Â±æÀÇ °ªÀÌ ´õ ÀÛ´Ù¸é
						graph[j][k] = graph[j][i] + graph[i][k];//°ÅÃÄ°¡´Â °ªÀ» ÀúÀå
					}
				}
			}
		}
	}
	public void printshortpath() {//°¢ ³ëµå¿¡¼­ ³ëµå·Î ¾Æµ¿ÇÏ´Âµ¥ °É¸®´Â ÃÖ¼Ò°¡ÁßÄ¡¸¦ ­‹·ÂÇÏ´Â ÇÔ¼ö
		for(int i=0; i<graph.length; i++) {
			for(int j=0; j<graph.length;j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}
//https://kingpodo.tistory.com/53
//https://m.blog.naver.com/PostView.nhn?blogId=dhdudwh1&logNo=220863482093&proxyReferer=https%3A%2F%2Fwww.google.com%2F
//int [][] gragh = new int [5][5];