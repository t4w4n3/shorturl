package fr.tawane.shorturl

class UrlMappings {
	static mappings = {
		"/$controller/$action?/$id?(.$format)?" {
			constraints {
				controller matches: 'shortUrl'
				action inList: ['show', 'index', 'save']
			}
		}

		"/$segment"(controller: 'shortUrl', action: 'redirect')

		"/"(controller: 'shortUrl', action: "create")
		"500"(view: '/error')
		"404"(view: '/notFound')
	}
}
