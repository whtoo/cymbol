package cymbol.model;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.codegen.model.ModelElement;
import org.antlr.v4.codegen.model.OutputModelObject;

import cymbol.symtab.BuiltInTypeSymbol;
import cymbol.symtab.StructSymbol;
import cymbol.symtab.Symbol;
import cymbol.symtab.VariableSymbol;

public class Struct extends OutputModelObject{

    public String name;
    
    @ModelElement public List<VariableDeclaration> vars = new ArrayList<VariableDeclaration>();
    @ModelElement public List<Struct> nested = new ArrayList<Struct>();
    
    public Struct(StructSymbol struct) {
       this.name = struct.getName();
       
       for(Symbol s : struct.getMembers().values()) {
           if(s instanceof VariableSymbol || s instanceof BuiltInTypeSymbol) { 
               vars.add(new VariableDeclaration(s)); 
           } else if (s instanceof StructSymbol) {
               nested.add(new Struct((StructSymbol) s));
           }
       }
    }

}