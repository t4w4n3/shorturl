package fr.tawane.shorturl

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ShortUrlServiceSpec extends Specification {

    ShortUrlService shortUrlService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ShortUrl(...).save(flush: true, failOnError: true)
        //new ShortUrl(...).save(flush: true, failOnError: true)
        //ShortUrl shortUrl = new ShortUrl(...).save(flush: true, failOnError: true)
        //new ShortUrl(...).save(flush: true, failOnError: true)
        //new ShortUrl(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //shortUrl.id
    }

    void "test get"() {
        setupData()

        expect:
        shortUrlService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ShortUrl> shortUrlList = shortUrlService.list(max: 2, offset: 2)

        then:
        shortUrlList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        shortUrlService.count() == 5
    }

    void "test delete"() {
        Long shortUrlId = setupData()

        expect:
        shortUrlService.count() == 5

        when:
        shortUrlService.delete(shortUrlId)
        sessionFactory.currentSession.flush()

        then:
        shortUrlService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ShortUrl shortUrl = new ShortUrl()
        shortUrlService.save(shortUrl)

        then:
        shortUrl.id != null
    }
}
