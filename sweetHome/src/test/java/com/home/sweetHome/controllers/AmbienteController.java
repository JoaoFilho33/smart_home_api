package com.home.sweetHome.controllers;

public class AmbienteController {
    //nessa forma de post eu leio "descrição" e "localId" direto no corpo da solicitação JSON

//    @PostMapping("/ambientes")
//    public ResponseEntity<Object> saveAmbiente(@RequestBody Map<String, Object> requestBody) {
//        try {
//            String descricao = (String) requestBody.get("descricao");
//            UUID localId = UUID.fromString((String) requestBody.get("localId"));
//
//            Optional<Local> localOptional = localRepository.findById(localId);
//
//            if (localOptional.isPresent()) {
//                Local local = localOptional.get();
//
//                Ambiente ambiente = new Ambiente();
//                ambiente.setDescricao(descricao);
//                ambiente.setLocal(local);
//
//                Ambiente novoAmbiente = ambienteRepository.save(ambiente);
//                logger.info("Ambiente criado com sucesso: {}", novoAmbiente.getId());
//                return ResponseEntity.status(HttpStatus.CREATED).body(novoAmbiente);
//            } else {
//                logger.error("Local não encontrado para o ID: {}", localId);
//                Map<String, String> errorResponse = new HashMap<>();
//                errorResponse.put("error", "Local não encontrado");
//                return ResponseEntity.badRequest().body(errorResponse);
//            }
//        } catch (DataIntegrityViolationException ex) {
//            logger.error("Erro de integridade de dados ao criar ambiente: {}", ex.getMessage());
//            Map<String, String> errorResponse = new HashMap<>();
//            errorResponse.put("error", "Erro de integridade de dados");
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//        }
//    }
}
