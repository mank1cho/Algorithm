// https://www.acmicpc.net/problem/16235
// 나무재테크
// 구현 시뮬레이션

package boj;

import java.io.*;
import java.util.*;

public class BOJ_16235_G4_나무재테크 {

	static class Tree implements Comparable<Tree>{
		int x, y, age;
		Tree(int x, int y, int age){
			this.x = x;
			this.y = y;
			this.age = age;
		}
		
		@Override
		public int compareTo(Tree o) {
			return Integer.compare(age, o.age);
		}
	}
	
	static int N, M, K;
	static int[][] Robot;
	static int[][] Map;
	
	static List<Tree> treeList;
	static Queue<Tree> aliveTree;
	static Queue<Tree> deadTree;
	static Queue<Tree> spreadTree;
	
	
	public static void main(String[] args) throws Exception {
		input();
		while(K-->0) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(aliveTree.size());
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Robot = new int[N][N];
		Map = new int[N][N];
		
		treeList = new ArrayList<>();
		aliveTree = new LinkedList<>();
		deadTree = new LinkedList<>();
		spreadTree = new LinkedList<>();
		
		for(int r = 0; r<N; ++r) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c<N; ++c) {
				Robot[r][c] = Integer.parseInt(st.nextToken());
				Map[r][c] = 5;
			}
		}
		
		for(int i = 0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			aliveTree.add(new Tree(x-1, y-1, z));
		}
		
	}

	public static void spring() {
		treeList.clear();
		
		while(!aliveTree.isEmpty()) {
			treeList.add(aliveTree.poll());
		}
		
		Collections.sort(treeList);
		
		for(Tree tree : treeList) {
			int x = tree.x;
			int y = tree.y;
			int age = tree.age;
			
			if(Map[x][y] >= age) {
				Map[x][y]-=age;
				age++;
				aliveTree.add(new Tree(x, y, age));
				if(age%5==0) {
					spreadTree.add(tree);
				}
			}
			
			else {
				deadTree.add(tree);
			}
		}
		
	}
	
	public static void summer() {
		while(!deadTree.isEmpty()) {
			Tree tree = deadTree.poll();
			Map[tree.x][tree.y]+=tree.age/2;
		}
	}
	
	static final int[] dx = {-1,-1,-1,0,1,1,1,0};
	static final int[] dy = {-1,0,1,1,1,0,-1,-1};
	
	public static void fall() {
		while(!spreadTree.isEmpty()) {
			Tree tree = spreadTree.poll();
			int x = tree.x;
			int y = tree.y;
			for(int i = 0; i<8; ++i) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(!isIn(nx, ny)) continue;
				aliveTree.add(new Tree(nx, ny, 1));
			}
		}
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	
	public static void winter() {
		for(int i = 0; i<N; ++i){
			for(int j = 0; j<N; ++j){
				Map[i][j]+=Robot[i][j];
			}
		}
	}
	
}