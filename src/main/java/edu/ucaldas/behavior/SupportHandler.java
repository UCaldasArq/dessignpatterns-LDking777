package edu.ucaldas.behavior;

// TODO: Implementa el patrón Chain of Responsibility.
// Crea tres manejadores concretos:
// 1. BasicSupportHandler → maneja solicitudes "básicas"
// 2. SupervisorHandler → maneja solicitudes "intermedias"
// 3. ManagerHandler → maneja solicitudes "avanzadas"
// Si no puede manejar, debe pasar al siguiente en la cadena.

public class SupportHandler {
    public static Handler createChain() {
        // crea la cadena: Basic → Supervisor → Manager
        Handler basic = new BasicSupportHandler();
        Handler supervisor = new SupervisorHandler();
        Handler manager = new ManagerHandler();
        basic.setNext(supervisor);
        supervisor.setNext(manager);
        return basic;
    }
}

class BasicSupportHandler extends Handler {
    @Override
    public String handleRequest(String request) {
        if (request == null) return "No se puede atender la solicitud.";
        if ("básica".equalsIgnoreCase(request) || "basica".equalsIgnoreCase(request)) {
            return "Atendido por Soporte Básico";
        }
        if (next != null) return next.handleRequest(request);
        return "No se puede atender la solicitud.";
    }
}

class SupervisorHandler extends Handler {
    @Override
    public String handleRequest(String request) {
        if (request == null) return "No se puede atender la solicitud.";
        if ("intermedia".equalsIgnoreCase(request) || "intermedio".equalsIgnoreCase(request)) {
            return "Atendido por Supervisor";
        }
        if (next != null) return next.handleRequest(request);
        return "No se puede atender la solicitud.";
    }
}

class ManagerHandler extends Handler {
    @Override
    public String handleRequest(String request) {
        if (request == null) return "No se puede atender la solicitud.";
        if ("avanzada".equalsIgnoreCase(request) || "avanzado".equalsIgnoreCase(request)) {
            return "Atendido por Gerente";
        }
        if (next != null) return next.handleRequest(request);
        return "No se puede atender la solicitud.";
    }
}
