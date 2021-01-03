package org.formacion.jpa.main;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Esta clase es construida por el container para indicar como obtener la 
 * informacion necesaria para construir el persistence unit
 */
class SimplePersistenceInfo implements PersistenceUnitInfo {

    private final String name;

    SimplePersistenceInfo(String name) {
        this.name = name;
    }

    @Override
    public String getPersistenceUnitName() {
        return name;
    }

    @Override
    public List<URL> getJarFileUrls() {
        try {
            return Collections.list(this.getClass()
                    .getClassLoader()
                    .getResources(""));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    // El resto de de metodos son tambien implementados por un contenedor "real"
    // pero no son necesarios para nuestro ejemplo
    
    @Override
    public String getPersistenceProviderClassName() {
        return null;
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return null;
    }

    @Override
    public DataSource getJtaDataSource() {
        return null;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return null;
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        return null;
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer transformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }


}
