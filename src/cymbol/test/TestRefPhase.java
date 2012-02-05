package cymbol.test;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import cymbol.compiler.Compiler;
import cymbol.symtab.SymbolTable;

public class TestRefPhase {

    @Test
    public void testReferenceGlobalVars() {
        String source = "int a;" +
        		        "char b;" +
        		        "float c;" +
        		        "struct D { int x; }" +
        		        "D d;" +
        		        "boolean t;";
        SymbolTable t = runTest(source);
        
    }

    public static SymbolTable runTest(String source) {
        ANTLRInputStream in = new ANTLRInputStream(source);
        Compiler c = new Compiler();
        ParseTree t = c.constructParseTree(in);
        SymbolTable table = c.define(t);
        c.reference(t, table);

        return table;
    }
}
