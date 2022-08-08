class Solution {
	static long nineDivisors(long N) {
		//Code Here

		int result = 0;
		int len = (int) Math.sqrt(N);
		int arr[] = new int[len + 1];
		for (int i = 1; i<= len; i++) {
			arr[i] = i;
		}

		for (int i = 2; i * i<= len; i++) {
			if (arr[i] == i) {
				for (int j = i * i; j<= len; j += i) {
					if (arr[j] == j) {
						arr[j] = i;
					}
				}
			}
		}

		for (int i = 2; i<= len; i++) {
			int first = arr[i];
			int idx = i / arr[i];
			int second = arr[idx];
			if (first * second == i && second != 1 && first != second) {
				result += 1;
			} else if (arr[i] == i) {

				if (Math.pow(i, 8)<= N) {

					result += 1;
				}
			}
		}

		return result;
	}
}
