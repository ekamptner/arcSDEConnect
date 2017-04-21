package gov.nyc.doitt.gis.arcSDEConnect

import spock.lang.*

import geoscript.workspace.*
import org.geotools.arcsde.data.*
import org.geotools.data.*
import org.geotools.arcsde.session.*
import org.geotools.arcsde.jndi.*
import org.geotools.arcsde.data.ArcSDEDataStore

import com.esri.sde.sdk.client.*

class SDEConnectTest extends Specification {
	SDEConnect sde

	def 'test getConfig'(){
		given:
			def sde = new SDEConnect()
			def instance = ''
			def password = ''
			def port = ''
			def server = ''
			def username = ''
			def minConnect = ''
			def maxConnect = ''
			def timeout = ''
		
		when:
			def config = sde.getConfig(instance, password, port, server, username, minConnect, maxConnect, timeout)
		
		then:
			assert config.toMap() != null	
			assert config.getConnTimeOut() == ''
			assert config.getMaxConnections() == ''
			assert config.getMinConnections() == ''
			assert config.getPassword() == ''
			assert config.getPortNumber() == ''
			assert config.getServerName() == ''
			assert config.getUserName() == ''
	}
	
	def 'test getSession'(){

	}
}