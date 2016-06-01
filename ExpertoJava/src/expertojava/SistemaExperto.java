package expertojava;

import Rule.BooleanRuleBase;
import Rule.Clause;
import Rule.Condition;
import Rule.Rule;
import Rule.RuleVariable;

public class SistemaExperto { 
    
    // Inicializamos variables a utilizar    
    BooleanRuleBase basedereglas = new BooleanRuleBase("basedereglas");
    RuleVariable Falda = new RuleVariable(basedereglas,"");
    RuleVariable Pantaloncillos = new RuleVariable(basedereglas,"");
    RuleVariable Moño = new RuleVariable(basedereglas,"");
    RuleVariable ColorMoño = new RuleVariable(basedereglas,"");
    RuleVariable Cabeza = new RuleVariable(basedereglas,"");
    RuleVariable ColorPlayera = new RuleVariable(basedereglas,"");
    RuleVariable ColorPelo = new RuleVariable(basedereglas,"");
    RuleVariable ResultadoRopa = new RuleVariable(basedereglas,"");
    RuleVariable ResultadoMoño = new RuleVariable(basedereglas,"");
    RuleVariable ResultadoColorMoño = new RuleVariable(basedereglas,"");
    RuleVariable ResultadoCabeza = new RuleVariable(basedereglas,"");
    RuleVariable ResultadoPlayera = new RuleVariable(basedereglas,"");
    RuleVariable ResultadoPelo = new RuleVariable(basedereglas,"");
    
    //Aqui establecemos nuestra base de conocimientos basado en predicados comparativos.
    public void basedeconocimiento (){
        Condition igual = new Condition("=");
        
        Rule reglauno = new Rule(basedereglas,"reglauno",new Clause[]{
            new Clause (Falda,igual,"si"),
            new Clause (Pantaloncillos,igual,"no"),
        }, new Clause(ResultadoRopa,igual,"TieneFalda"));
        
        Rule reglados = new Rule(basedereglas,"reglados",new Clause[]{
            new Clause (Falda,igual,"no"),
            new Clause (Pantaloncillos,igual,"si"),
        }, new Clause(ResultadoRopa,igual,"TienePantaloncillos"));
        
        Rule reglatres = new Rule(basedereglas,"reglatres",new Clause[]{
            new Clause (Falda,igual,"no"),
            new Clause (Pantaloncillos,igual,"no"),
        }, new Clause(ResultadoRopa,igual,"Tu personaje es Perry el ornitorrinco"));
        
        Rule reglacuatro = new Rule(basedereglas,"reglacuatro",new Clause[]{
            new Clause (ResultadoRopa,igual,"TieneFalda"),
            new Clause (Moño,igual,"si"),
        }, new Clause(ResultadoMoño,igual,"TieneMoño"));
        
        Rule reglacinco = new Rule(basedereglas,"reglacinco",new Clause[]{
            new Clause (ResultadoRopa,igual,"TieneFalda"),
            new Clause (Moño,igual,"no"),
        }, new Clause(ResultadoMoño,igual,"Tu personaje es Candace"));
        
        Rule reglaseis = new Rule(basedereglas,"reglaseis",new Clause[]{
            new Clause (ResultadoRopa,igual,"TienePantaloncillos"),
            new Clause (Cabeza,igual,"si"),
        }, new Clause(ResultadoCabeza,igual,"Tu personaje es Phineas"));
        
        Rule reglasiete = new Rule(basedereglas,"reglasiete",new Clause[]{
            new Clause (ResultadoRopa,igual,"TienePantaloncillos"),
            new Clause (Cabeza,igual,"no"),
        }, new Clause(ResultadoCabeza,igual,"NoPhineas"));
        
        Rule reglaocho = new Rule(basedereglas,"reglaocho",new Clause[]{
            new Clause (ResultadoMoño,igual,"TieneMoño"),
            new Clause (ColorMoño,igual,"si"),
        }, new Clause(ResultadoColorMoño,igual,"Tu personaje es Isabella"));
        
        Rule reglanueve = new Rule(basedereglas,"reglanueve",new Clause[]{
            new Clause (ResultadoMoño,igual,"TieneMoño"),
            new Clause (ColorMoño,igual,"no"),
        }, new Clause(ResultadoColorMoño,igual,"Tu personaje es Stacy"));
        
        Rule regladiez = new Rule(basedereglas,"regladiez",new Clause[]{
            new Clause (ResultadoCabeza,igual,"NoPhineas"),
            new Clause (ColorPlayera,igual,"si"),
        }, new Clause(ResultadoPlayera,igual,"Tu personaje es Bufford"));
        
        Rule reglaonce = new Rule(basedereglas,"reglaonce",new Clause[]{
            new Clause (ResultadoCabeza,igual,"NoPhineas"),
            new Clause (ColorPlayera,igual,"no"),
        }, new Clause(ResultadoPlayera,igual,"NoBufford"));
        
        Rule regladoce = new Rule(basedereglas,"regladoce",new Clause[]{
            new Clause (ResultadoPlayera,igual,"NoBufford"),
            new Clause (ColorPelo,igual,"si"),
        }, new Clause(ResultadoPelo,igual,"Tu personaje es Ferb"));
        
        Rule reglatrece = new Rule(basedereglas,"reglatrece",new Clause[]{
            new Clause (ResultadoPlayera,igual,"NoBufford"),
            new Clause (ColorPelo,igual,"no"),
        }, new Clause(ResultadoPelo,igual,"Tu personaje es Baljeet"));
        
    }
    
    //Aqui inician las funciones para asignar valores y crear el motor de inferencia
    public String ObtenerRopa (String falda, String pantaloncillos){
        basedeconocimiento();
        Falda.setValue(falda);
        Pantaloncillos.setValue(pantaloncillos);
        basedereglas.forwardChain();
        return ResultadoRopa.getValue();
    }
    
    public String ObtenerMoño (String resultadoropa, String moño){
        basedeconocimiento();
        ResultadoRopa.setValue(resultadoropa);
        Moño.setValue(moño);
        basedereglas.forwardChain();
        return ResultadoMoño.getValue();
    }
    
    public String ObtenerColorMoño (String resultadomoño, String colormoño){
        basedeconocimiento();
        ResultadoMoño.setValue(resultadomoño);
        ColorMoño.setValue(colormoño);
        basedereglas.forwardChain();
        return ResultadoColorMoño.getValue();
    }
    
    public String ObtenerCabeza (String resultadoropa, String cabeza){
        basedeconocimiento();
        ResultadoRopa.setValue(resultadoropa);
        Cabeza.setValue(cabeza);
        basedereglas.forwardChain();
        return ResultadoCabeza.getValue();
    }
    
    public String ObtenerPlayera (String resultadocabeza, String playera){
        basedeconocimiento();
        ResultadoCabeza.setValue(resultadocabeza);
        ColorPlayera.setValue(playera);
        basedereglas.forwardChain();
        return ResultadoPlayera.getValue();
    }
    
    public String ObtenerPelo (String resultadoplayera, String pelo){
        basedeconocimiento();
        ResultadoPlayera.setValue(resultadoplayera);
        ColorPelo.setValue(pelo);
        basedereglas.forwardChain();
        return ResultadoPelo.getValue();
    }
}
