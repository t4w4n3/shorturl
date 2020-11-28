package shorturl2

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ShortUrlController {

    static scaffold = ShortUrl

    ShortUrlService shortUrlService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond shortUrlService.list(params), model:[shortUrlCount: shortUrlService.count()]
    }

    def show(Long id) {
        respond shortUrlService.get(id)
    }

    def create() {
        respond new ShortUrl(params)
    }

    def save(ShortUrl shortUrl) {
        if (shortUrl == null) {
            notFound()
            return
        }

        try {
            shortUrlService.save(shortUrl)
        } catch (ValidationException e) {
            respond shortUrl.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'shortUrl.label', default: 'ShortUrl'), shortUrl.id])
                redirect shortUrl
            }
            '*' { respond shortUrl, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond shortUrlService.get(id)
    }

    def update(ShortUrl shortUrl) {
        if (shortUrl == null) {
            notFound()
            return
        }

        try {
            shortUrlService.save(shortUrl)
        } catch (ValidationException e) {
            respond shortUrl.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'shortUrl.label', default: 'ShortUrl'), shortUrl.id])
                redirect shortUrl
            }
            '*'{ respond shortUrl, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        shortUrlService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'shortUrl.label', default: 'ShortUrl'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'shortUrl.label', default: 'ShortUrl'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
