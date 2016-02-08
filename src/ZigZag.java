import java.util.Arrays;

/**
 * Solution to <a href="https://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493">ZigZag</a>
 * 
 * @author clan
 *
 */
public class ZigZag {
	
	public int longestZigZag(int[] in) {
		int[][] cache = new int[2][];
		//up
		cache[0] = new int[in.length];
		Arrays.fill(cache[0], 1);
		//down
		cache[1] = new int[in.length];
		Arrays.fill(cache[1], 1);
		int max = 1;
		for (int end = 1; end < in.length; end++) {
			for (int start = 0; start < end; start++) {
				//update up array by checking down array
				if (in[end] > in[start] && cache[1][start] + 1 > cache[0][end]) {
					cache[0][end] = cache[1][start] + 1;
				}
				//update down array by check up array
				if (in[end] < in[start] && cache[0][start] + 1 > cache[1][end]) {
					cache[1][end] = cache[0][start] + 1;
				}
				max = Math.max(max, Math.max(cache[0][end], cache[1][end]));
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new ZigZag().longestZigZag(new int[] {396, 549, 22, 819, 611, 972, 730, 638, 978, 342, 566, 514, 752, 871, 911, 172, 488, 542, 482, 974, 210, 474, 66, 387, 1, 872, 799, 262, 567, 113, 578, 308, 813, 515, 716, 905, 434, 101, 632, 450, 74, 254, 1000, 780, 633, 496, 513, 772, 925, 746}));
	}

}
