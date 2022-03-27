package com.example.voice

class List() {

    private var title: String? = null
    private var body: String? = null

    fun Lists(title: String?, body: String?) {
        this.title = title
        this.body = body
    }

    protected fun getTitle(): String? {
        return title
    }

    protected fun getBody(): String? {
        return body
    }
}