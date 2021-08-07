package generator

import accessor.TableAccessor
import dbobjects.GTable
import metadata.GeneratorMetaData
import org.apache.velocity.Template
import org.apache.velocity.VelocityContext
import org.apache.velocity.app.VelocityEngine
import org.apache.velocity.runtime.RuntimeConstants
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader


class EntityTemplate {


    def tables = []
    def tableMap = [:]
    def generator
    def packageName ="org.enargit.data.entities"
    def outputDir = new File("/home/tadams/Projects/karaf/new-projects/entity-generator/output/org/enargit/data/entities")

    StringWriter render(GeneratorMetaData generator, GTable[] tables, GTable table) {

        VelocityEngine engine = new VelocityEngine()
        engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        engine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        Template template = engine.getTemplate("pojoTemplate.vm")

        VelocityContext context = new VelocityContext();
        context.put("table", table )
        context.put("tables", tables )
        context.put("generator", generator )
        context.put("packageName", packageName )

        File javaFile = new File(outputDir.absolutePath + "/" + table.javaName + ".java")
        FileWriter fileWriter = new FileWriter(javaFile);

        StringWriter writer = new StringWriter()
        template.merge(context, writer)
        template.merge(context, fileWriter)
        fileWriter.close()
        return writer
    }

    static void main(String[] args) {
        TableAccessor access = new TableAccessor()
        GTable[] tables = access.getGTables()
        def tableMap = [:]
        tables.each { it -> tableMap.put(it.name, it)}
        def et = new EntityTemplate()
        et.tables = tables
        GeneratorMetaData generator = new GeneratorMetaData();
        generator.initTables()
        generator.tableMap = tableMap
        tables.each { it ->
            println(et.render(generator, tables, it).toString())
        }
    }


}
