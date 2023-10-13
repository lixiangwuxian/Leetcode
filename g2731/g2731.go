package main

import "sort"

func sumDistance(nums []int, s string, d int) int {
	for i := 0; i < len(s); i++ {
		if s[i] == 'R' {
			nums[i] += d
		} else {
			nums[i] -= d
		}
	}
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})
	var sum int
	for i := 1; i < len(s); i++ {
		sum += (nums[i] - nums[i-1]) * i % 1000000007 * (len(nums) - i) % 1000000007
		sum %= 1000000007
	}
	return sum
}
