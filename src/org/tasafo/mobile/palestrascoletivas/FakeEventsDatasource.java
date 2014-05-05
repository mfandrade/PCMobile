package org.tasafo.mobile.palestrascoletivas;

import java.util.LinkedList;
import java.util.List;

public class FakeEventsDatasource {

    private List<Event> events;

    public FakeEventsDatasource() {
	// @formatter:off
	events = new LinkedList<Event>();
	events.add(new Event("Agilidade em Ação", "Desenvolvimento de Produto", "Esse evento irá demonstrar como planejar e desenvolver seu produto colocando-o em produção rapidamente. Ao final teremos um intenso debate sobre os temas apresentados.", "2014-04-26", 1, "HUB 728", "Rua Angelo Custódio, 728A, Cidade Velha, Belém, Pará, Brasil"));
	events.add(new Event("Semana do Calouro UFRA", "2014", "Tá Safo! Em Ação durante a Semana de Calouros da Universidade Federal Rural da Amazônia (UFRA).", "2014-02-19", 1, "UFRA", "Av. Perimetral da Ciência, 2501, Terra Firme, Belém, Pará, Brasil"));
	events.add(new Event("#TáSafoEmAção", "Aplicações performáticas para a web", "Evento para a comunidade de Tecnologia da Informação que trata de assuntos inerentes ao desenvolvimento e infraestrutura para aplicações em ambientes web.", "2013-11-22", 1, "CESUPA José Malcher", "Avenida Governador José Malcher, 1963, Nazaré, Belém, Pará, Brasil"));
	events.add(new Event("Agilidade em Ação", "2013-11", "Existem maneiras melhores de desenvolver software.", "2013-11-05", 1, "CESUPA José Malcher", "Avenida Governador José Malcher, 1963, Nazaré, Belém, Pará, Brasil"));
	events.add(new Event("#TáSafoEmAção", "VI Semana Acadêmica FCAT", "Evento para os acadêmicos da instituição.", "2013-10-22", 1, "FCAT", "Rodovia BR 316 Km 60, s/n, Centro, Castanhal, Pará, Brasil"));
	events.add(new Event("#TáSafoEmAção", "Managing Dojo com Manoel Pimentel", "Managing Dojo é uma técnica, criada e socializada por Manoel Pimentel, para exercitar novos pensamentos e soluções para ajudar a gerir organizações complexas. +info: http://www.managingdojo.org/p/funcionamento.html local: http://www.fga10.com/#!portfolio/cjg9 ", "2013-10-17", 1, "Ed. Evolution", "Rua D. Romualdo de Seixas, 1476 Ed. , Umarizal, Belém, Pará, Brazil"));
	events.add(new Event("#TáSafoEmAção", "VIII Computação Amostra", " Participação da Comunidade Tá Safo! durante o VIII Computação Amostra.", "2013-05-24", 1, "CESUPA José Malcher", "Avenida Governador José Malcher, 1963, Nazaré, Belém, Pará, Brasil"));
	events.add(new Event("FLISOL", "Belém 2013", "O FLISOL (Festival Latino-americano de Instalação de Software Livre) é o maior evento de divulgação de Software Livre da América Latina. Ele acontece desde 2005 e seu principal objetivo é promover o uso de software livre, apresentando sua filosofia, seu alcance, avanços e desenvolvimento ao público em geral. Mais informações http://www.ubuntupaidegua.com.br", "2013-04-27", 1, "CESUPA José Malcher", "Avenida Governador José Malcher, 1963, Nazaré, Belém, Pará, Brasil"));
	events.add(new Event("#TáSafoEmAção", "Coding Dojo FACI", "Evento destinado aos alunos e comunidade de tecnologia da região com foco em exercícios de programação mas conhecidos como Coding Dojo.", "2013-04-25", 1, "FACI", "Rua dos Tupinambás, 461, Batista Campos, Belém, Pará, Brasil"));
	events.add(new Event("Semana do Calouro UFRA", "2013", "Tá Safo! Em Ação durante a Semana de Calouros da Universidade Federal Rural da Amazônia (UFRA).", "2013-04-17", 1, "UFRA", "Av. Perimetral da Ciência, 2501, Terra Firme, Belém, Pará, Brasil"));
	events.add(new Event("#TáSafoEmAção", "Mobile", "Evento #TáSafoEmAção no Parque Tecnológico do Guamá com o tema: MOBILE", "2013-03-23", 1, "UFPA", "Avenida Perimetral, 1000, Guamá, Belém, Pará, Brasil"));
	events.add(new Event("#TáSafoEmAção", "FACI - Com Rildo Santos", "Evento #TáSafoEmAção", "2013-03-20", 1, "Campus FACI", "Rua dos Mundurucus, 1427, Batista Campos, Belém, Pará, Brasil"));
	events.add(new Event("#TáSafoEmAção", "FACI - Carreira Profissional", "Evento #TáSafoEmAção", "2013-02-19", 1, "FACI", "Travessa dos Tupinambás, 461, Batista Campos, Belém, Pará, Brasil"));
	// @formatter:on
    }

    public List<Event> getAll() {
	return events;
    }

}
