package gov.nyc.doitt.gis.arcSDEConnect

import geoscript.workspace.*
import org.geotools.arcsde.data.*
import org.geotools.data.*
import org.geotools.arcsde.session.*
import org.geotools.arcsde.jndi.*
import org.geotools.arcsde.data.ArcSDEDataStore

import com.esri.sde.sdk.client.*

//connection parameters
	def instance = ''
	def password = ''
	def port = ''
	def server = ''
	def username = ''
	def minConnect = ''
	def maxConnect = ''
	def timeout = ''


def run(instance, password, port, server, username){
	def config = getConfig(instance, password, port, server, username)
	def session = getSession(config)
	def datastore = getDataStore(factory)
	def myDatabase = getDatabase(datastore)
}

//get arcsdeconnectionconfig file. 
def getConfig(instance, password, port, server, username, minConnect, maxConnect, timeout){

	ArcSDEConnectionConfig config = new ArcSDEConnectionConfig()
	config.setPortNumber(port)
	config.setDatabaseName(instance) 
	config.setUserName(username) 
	config.setPassword(password) 
	config.setMinConnections(Integer.parseInt(minConnect)) 
	config.setMaxConnections(Integer.parseInt(maxConnect))
	config.setConnTimeOut(Integer.parseInt(timeout))
	config.setServerName(server)

	return config
	}

//get session by for arcsdeconnectionFactory
def getSession(config){	
	ArcSDEConnectionFactory factory = new ArcSDEConnectionFactory()
	ISessionPool session = factory.getInstance(config)

	return session
}

def getDataStore(factory){
	DataStore arcDS = ArcSDEDataStore(factory)
	return arcDS
	}

def getDatabase(datastore){
	Database myDatabase = Database(arcDS)
	return myDatabase
	}


