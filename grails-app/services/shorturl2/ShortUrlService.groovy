package shorturl2

import grails.gorm.services.Service

@Service(ShortUrl)
interface ShortUrlService {

    ShortUrl get(Serializable id)

    List<ShortUrl> list(Map args)

    Long count()

    void delete(Serializable id)

    ShortUrl save(ShortUrl shortUrl)

}