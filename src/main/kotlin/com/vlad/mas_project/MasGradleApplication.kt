package com.vlad.mas_project

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@SpringBootApplication
class MasGradleApplication

fun main(args: Array<String>) {
	runApplication<MasGradleApplication>(*args){
		setBannerMode(Banner.Mode.OFF)
	}
}