-- Limpar dados existentes (opcional - cuidado em produção)
-- SET FOREIGN_KEY_CHECKS = 0;
-- TRUNCATE TABLE order_items;
-- TRUNCATE TABLE orders;
-- TRUNCATE TABLE products;
-- TRUNCATE TABLE users;
-- SET FOREIGN_KEY_CHECKS = 1;

-- ============================================
-- INSERINDO 100 USUÁRIOS
-- ============================================
INSERT INTO users (name, email, created_at) VALUES
('João Silva', 'joao.silva@email.com', '2024-01-15 10:30:00'),
('Maria Oliveira', 'maria.oliveira@email.com', '2024-01-16 14:20:00'),
('Carlos Santos', 'carlos.santos@email.com', '2024-01-17 09:15:00'),
('Ana Paula Costa', 'ana.costa@email.com', '2024-01-18 16:45:00'),
('Pedro Alves', 'pedro.alves@email.com', '2024-01-19 11:00:00'),
('Fernanda Lima', 'fernanda.lima@email.com', '2024-01-20 13:30:00'),
('Ricardo Mendes', 'ricardo.mendes@email.com', '2024-01-21 08:00:00'),
('Patrícia Rocha', 'patricia.rocha@email.com', '2024-01-22 17:15:00'),
('André Ferreira', 'andre.ferreira@email.com', '2024-01-23 10:45:00'),
('Camila Barros', 'camila.barros@email.com', '2024-01-24 12:00:00'),
('Lucas Ribeiro', 'lucas.ribeiro@email.com', '2024-01-25 09:30:00'),
('Juliana Castro', 'juliana.castro@email.com', '2024-01-26 15:20:00'),
('Marcos Paulo', 'marcos.paulo@email.com', '2024-01-27 11:45:00'),
('Renata Souza', 'renata.souza@email.com', '2024-01-28 14:10:00'),
('Eduardo Gomes', 'eduardo.gomes@email.com', '2024-01-29 08:30:00'),
('Tatiana Martins', 'tatiana.martins@email.com', '2024-01-30 16:00:00'),
('Roberto Nunes', 'roberto.nunes@email.com', '2024-01-31 13:45:00'),
('Simone Carvalho', 'simone.carvalho@email.com', '2024-02-01 10:15:00'),
('Gustavo Araujo', 'gustavo.araujo@email.com', '2024-02-02 15:30:00'),
('Luciana Freitas', 'luciana.freitas@email.com', '2024-02-03 12:45:00'),
('Thiago Barbosa', 'thiago.barbosa@email.com', '2024-02-04 09:00:00'),
('Aline Cardoso', 'aline.cardoso@email.com', '2024-02-05 17:30:00'),
('Rafael Teixeira', 'rafael.teixeira@email.com', '2024-02-06 11:15:00'),
('Vanessa Correia', 'vanessa.correia@email.com', '2024-02-07 14:45:00'),
('Bruno Mendonça', 'bruno.mendonca@email.com', '2024-02-08 08:45:00'),
('Cristina Linhares', 'cristina.linhares@email.com', '2024-02-09 16:30:00'),
('Daniel Moreira', 'daniel.moreira@email.com', '2024-02-10 10:00:00'),
('Elaine Pires', 'elaine.pires@email.com', '2024-02-11 13:15:00'),
('Fábio Rezende', 'fabio.rezende@email.com', '2024-02-12 15:45:00'),
('Gabriela Antunes', 'gabriela.antunes@email.com', '2024-02-13 09:45:00'),
('Heitor Viana', 'heitor.viana@email.com', '2024-02-14 12:30:00'),
('Isabela Maia', 'isabela.maia@email.com', '2024-02-15 16:15:00'),
('Jorge Neves', 'jorge.neves@email.com', '2024-02-16 10:30:00'),
('Kelly Figueiredo', 'kelly.figueiredo@email.com', '2024-02-17 14:00:00'),
('Leandro Marques', 'leandro.marques@email.com', '2024-02-18 11:45:00'),
('Michele Batista', 'michele.batista@email.com', '2024-02-19 13:30:00'),
('Nelson Assis', 'nelson.assis@email.com', '2024-02-20 09:15:00'),
('Olívia Moura', 'olivia.moura@email.com', '2024-02-21 17:00:00'),
('Paulo Gonçalves', 'paulo.goncalves@email.com', '2024-02-22 15:15:00'),
('Queila Junqueira', 'queila.junqueira@email.com', '2024-02-23 08:30:00'),
('Rodrigo Tavares', 'rodrigo.tavares@email.com', '2024-02-24 12:45:00'),
('Silvia Ventura', 'silvia.ventura@email.com', '2024-02-25 14:30:00'),
('Tiago Lopes', 'tiago.lopes@email.com', '2024-02-26 10:15:00'),
('Ursula Damasceno', 'ursula.damasceno@email.com', '2024-02-27 16:45:00'),
('Vinícius Ramos', 'vinicius.ramos@email.com', '2024-02-28 09:30:00'),
('Wagner Faria', 'wagner.faria@email.com', '2024-02-29 11:00:00'),
('Ximena Salles', 'ximena.salles@email.com', '2024-03-01 13:45:00'),
('Yuri Pacheco', 'yuri.pacheco@email.com', '2024-03-02 15:30:00'),
('Zélia Campos', 'zelia.campos@email.com', '2024-03-03 08:15:00'),
('Adriano Melo', 'adriano.melo@email.com', '2024-03-04 14:45:00'),
('Beatriz Cunha', 'beatriz.cunha@email.com', '2024-03-05 12:00:00'),
('Caio Estrela', 'caio.estrela@email.com', '2024-03-06 16:30:00'),
('Débora Valente', 'debora.valente@email.com', '2024-03-07 09:45:00'),
('Emílio Sales', 'emilio.sales@email.com', '2024-03-08 11:30:00'),
('Fabiana Torres', 'fabiana.torres@email.com', '2024-03-09 14:15:00'),
('Gilson Castro', 'gilson.castro@email.com', '2024-03-10 17:45:00'),
('Helena Brito', 'helena.brito@email.com', '2024-03-11 08:00:00'),
('Ivan Duarte', 'ivan.duarte@email.com', '2024-03-12 13:30:00'),
('Janete Vilela', 'janete.vilela@email.com', '2024-03-13 15:45:00'),
('Kleber Andrade', 'kleber.andrade@email.com', '2024-03-14 10:00:00'),
('Larissa Xavier', 'larissa.xavier@email.com', '2024-03-15 12:30:00'),
('Márcio Peixoto', 'marcio.peixoto@email.com', '2024-03-16 09:15:00'),
('Nádia Serrano', 'nadia.serrano@email.com', '2024-03-17 16:00:00'),
('Osmar Pimenta', 'osmar.pimenta@email.com', '2024-03-18 14:45:00'),
('Priscila Zago', 'priscila.zago@email.com', '2024-03-19 11:15:00'),
('Quirino Fontes', 'quirino.fontes@email.com', '2024-03-20 08:30:00'),
('Rosângela Guerra', 'rosangela.guerra@email.com', '2024-03-21 13:00:00'),
('Sérgio Horta', 'sergio.horta@email.com', '2024-03-22 15:30:00'),
('Telma Iglesias', 'telma.iglesias@email.com', '2024-03-23 10:45:00'),
('Ubirajara Jorge', 'ubirajara.jorge@email.com', '2024-03-24 14:00:00'),
('Vera Knopik', 'vera.knopik@email.com', '2024-03-25 09:30:00'),
('Wesley Lins', 'wesley.lins@email.com', '2024-03-26 16:15:00'),
('Xênia Mota', 'xenia.mota@email.com', '2024-03-27 11:45:00'),
('Yasmin Novais', 'yasmin.novais@email.com', '2024-03-28 13:15:00'),
('Zacarias Otoni', 'zacarias.otoni@email.com', '2024-03-29 08:45:00'),
('Alice Barcelos', 'alice.barcelos@email.com', '2024-03-30 12:00:00'),
('Bernardo Carmo', 'bernardo.carmo@email.com', '2024-03-31 14:30:00'),
('Carolina Dorneles', 'carolina.dorneles@email.com', '2024-04-01 10:15:00'),
('Diego Escobar', 'diego.escobar@email.com', '2024-04-02 15:45:00'),
('Érica Fialho', 'erica.fialho@email.com', '2024-04-03 09:00:00'),
('Flávio Guimarães', 'flavio.guimaraes@email.com', '2024-04-04 11:30:00'),
('Gisele Holanda', 'gisele.holanda@email.com', '2024-04-05 13:45:00'),
('Henrique Ikeda', 'henrique.ikeda@email.com', '2024-04-06 16:00:00'),
('Iracema Jordão', 'iracema.jordao@email.com', '2024-04-07 08:30:00'),
('Joana Kato', 'joana.kato@email.com', '2024-04-08 14:15:00'),
('Leonardo Luz', 'leonardo.luz@email.com', '2024-04-09 10:45:00'),
('Manoela Mattos', 'manoela.mattos@email.com', '2024-04-10 12:30:00'),
('Natália Nogueira', 'natalia.nogueira@email.com', '2024-04-11 15:00:00'),
('Otávio Oliveira', 'otavio.oliveira@email.com', '2024-04-12 09:45:00'),
('Paula Prado', 'paula.prado@email.com', '2024-04-13 11:15:00'),
('Ronaldo Quaresma', 'ronaldo.quaresma@email.com', '2024-04-14 13:30:00'),
('Sabrina Rios', 'sabrina.rios@email.com', '2024-04-15 16:45:00'),
('Tomás Santana', 'tomas.santana@email.com', '2024-04-16 08:15:00'),
('Valéria Trindade', 'valeria.trindade@email.com', '2024-04-17 14:00:00'),
('Wilson Uchoa', 'wilson.uchoa@email.com', '2024-04-18 10:00:00'),
('Yara Vasconcelos', 'yara.vasconcelos@email.com', '2024-04-19 12:45:00'),
('Zilda Werneck', 'zilda.werneck@email.com', '2024-04-20 15:30:00'),
('Artur Xavier', 'artur.xavier@email.com', '2024-04-21 09:15:00'),
('Bianca Young', 'bianca.young@email.com', '2024-04-22 11:00:00'),
('César Zanon', 'cesar.zanon@email.com', '2024-04-23 13:45:00');

-- ============================================
-- INSERINDO 100 PRODUTOS
-- ============================================
INSERT INTO products (name, description, price, stock, created_at) VALUES
('Notebook Dell Inspiron', 'Notebook Dell Inspiron 15 3000, Intel Core i5, 8GB RAM, 256GB SSD', 3499.99, 50, '2024-01-01 10:00:00'),
('Smartphone Samsung Galaxy S23', 'Smartphone Samsung Galaxy S23, 128GB, Tela 6.1", Câmera 50MP', 4299.99, 30, '2024-01-02 11:00:00'),
('Monitor LG 24"', 'Monitor LG UltraGear 24" Full HD, 144Hz, 1ms, HDMI e DisplayPort', 1299.99, 80, '2024-01-03 09:00:00'),
('Teclado Mecânico HyperX', 'Teclado Mecânico HyperX Alloy Origins, Switch Red, RGB', 499.99, 120, '2024-01-04 14:00:00'),
('Mouse Gamer Logitech G403', 'Mouse Gamer Logitech G403 Hero, 16000 DPI, RGB', 249.99, 200, '2024-01-05 16:00:00'),
('Headset Kingston HyperX', 'Headset Kingston HyperX Cloud Stinger, Surround 7.1', 299.99, 150, '2024-01-06 10:30:00'),
('SSD Kingston 480GB', 'SSD Kingston A400, 480GB, SATA III, Leitura 500MB/s', 289.99, 300, '2024-01-07 08:45:00'),
('Memória RAM Corsair 8GB', 'Memória RAM Corsair Vengeance LPX 8GB DDR4 3200MHz', 199.99, 250, '2024-01-08 13:15:00'),
('Placa de Vídeo RTX 3060', 'Placa de Vídeo NVIDIA RTX 3060 12GB GDDR6', 2499.99, 40, '2024-01-09 11:45:00'),
('Gabinete Gamer TGT', 'Gabinete Gamer TGT Halo 300, Lateral em Vidro, 3 Fans RGB', 399.99, 90, '2024-01-10 15:30:00'),
('Fonte Corsair 650W', 'Fonte Corsair CV650, 650W, 80 Plus Bronze', 459.99, 70, '2024-01-11 09:00:00'),
('Webcam Logitech C270', 'Webcam Logitech C270 HD 720p, Microfone Integrado', 199.99, 100, '2024-01-12 12:00:00'),
('Adaptador Wi-Fi AC600', 'Adaptador Wi-Fi USB AC600, Dual Band, 5dBi', 79.99, 500, '2024-01-13 14:30:00'),
('HD Externo Seagate 1TB', 'HD Externo Seagate Expansion 1TB, USB 3.0', 349.99, 150, '2024-01-14 10:15:00'),
('Smartwatch Xiaomi Mi Band 7', 'Smartwatch Xiaomi Mi Band 7, Tela 1.62", Monitor Cardíaco', 249.99, 200, '2024-01-15 16:45:00'),
('Fone Bluetooth Anker', 'Fone Bluetooth Anker Soundbuds Life, 12h de bateria', 199.99, 180, '2024-01-16 08:00:00'),
('Carregador Rápido 65W', 'Carregador Rápido GaN 65W, USB-C, para Notebook/Celular', 129.99, 300, '2024-01-17 11:30:00'),
('Tablet Samsung Galaxy Tab A8', 'Tablet Samsung Galaxy Tab A8 10.5", 64GB, Wi-Fi', 1599.99, 60, '2024-01-18 13:45:00'),
('Roteador TP-Link AX10', 'Roteador TP-Link AX10 Wi-Fi 6, 1500Mbps, 4 Antenas', 399.99, 85, '2024-01-19 09:30:00'),
('Cadeira Gamer DT3', 'Cadeira Gamer DT3 Sports I300, Reclinável, Ajuste de Altura', 899.99, 45, '2024-01-20 15:00:00'),
('Mousepad Gamer Fnatic', 'Mousepad Gamer Fnatic Focus 3, Tamanho G, Controle de Umidade', 129.99, 250, '2024-01-21 10:45:00'),
('Microfone Blue Yeti', 'Microfone Blue Yeti USB, Condensador, Padrões Polares', 799.99, 35, '2024-01-22 14:15:00'),
('Caixa de Som JBL Flip 6', 'Caixa de Som JBL Flip 6, Bluetooth, 30W, Resistente a Água', 699.99, 55, '2024-01-23 12:30:00'),
('Controle Xbox Series X', 'Controle Sem Fio Xbox Series X, Bluetooth/USB-C', 399.99, 110, '2024-01-24 08:45:00'),
('Placa-mãe B550M', 'Placa-mãe ASUS TUF B550M-Plus, AMD AM4, DDR4', 899.99, 65, '2024-01-25 16:00:00'),
('Cooler CPU Cooler Master', 'Cooler CPU Cooler Master Hyper H410R, 120mm, RGB', 199.99, 130, '2024-01-26 09:15:00'),
('Impressora Epson L3250', 'Impressora Multifuncional Epson EcoTank L3250, Wi-Fi', 1099.99, 40, '2024-01-27 11:00:00'),
('Scanner Brother ADS-1200', 'Scanner Brother ADS-1200, Alimentador Automático, USB 3.0', 1299.99, 25, '2024-01-28 13:30:00'),
('Monitor Vertical 22"', 'Monitor Dell P2222H 22" Full HD, Ajuste de Altura', 999.99, 50, '2024-01-29 15:45:00'),
('Suporte para Monitor', 'Suporte Articulado para Monitor, Braço Duplo, Até 32"', 249.99, 100, '2024-01-30 10:00:00'),
('Hub USB 3.0 7 Portas', 'Hub USB 3.0 7 Portas com Carregador, 60W', 159.99, 200, '2024-01-31 12:45:00'),
('Cabo HDMI 2.0 3m', 'Cabo HDMI 2.0 3m, Suporte 4K, 60Hz, HDR', 39.99, 500, '2024-02-01 14:30:00'),
('Pen Drive 64GB', 'Pen Drive SanDisk Ultra Flair 64GB, USB 3.0, 150MB/s', 59.99, 400, '2024-02-02 08:15:00'),
('Cartão SD 128GB', 'Cartão SD SanDisk Extreme 128GB, UHS-I, 4K', 149.99, 300, '2024-02-03 16:30:00'),
('Adaptador USB-C para HDMI', 'Adaptador USB-C para HDMI 4K, 60Hz', 89.99, 250, '2024-02-04 11:45:00'),
('Base Resfriadora Notebook', 'Base Resfriadora com 3 Fans, Ajuste de Altura, USB', 79.99, 150, '2024-02-05 09:00:00'),
('KIT Teclado e Mouse Sem Fio', 'KIT Teclado e Mouse Logitech MK235, 2.4GHz', 199.99, 180, '2024-02-06 13:15:00'),
('Luminária RGB LED', 'Fita de LED RGB 5m com Controle Remoto, 5050', 49.99, 600, '2024-02-07 10:30:00'),
('Organizador de Cabos', 'Organizador de Cabos com 10 presilhas adesivas', 29.99, 800, '2024-02-08 15:45:00'),
('Pasta Térmica', 'Pasta Térmica Thermal Grizzly Kryonaut, 1g', 49.99, 200, '2024-02-09 12:00:00'),
('Limpa Contatos', 'Spray Limpa Contatos Eletrônico 200ml', 29.99, 150, '2024-02-10 14:15:00'),
('Parafusos para SSD', 'KIT Parafusos para SSD/HD, 10 unidades com chave', 19.99, 500, '2024-02-11 09:45:00'),
('Cabo SATA III', 'Cabo SATA III 45cm, com trava, 2 unidades', 15.99, 400, '2024-02-12 11:30:00'),
('Espuma Limpa Fone', 'Espuma de Reposição para Headset, 2 pares', 24.99, 250, '2024-02-13 16:00:00'),
('Película Notebook 15.6"', 'Película Antirreflexo para Notebook 15.6", Protetor', 39.99, 120, '2024-02-14 08:45:00'),
('Capa para Tablet 10"', 'Capa Protetora para Tablet 10", com suporte', 59.99, 100, '2024-02-15 13:30:00'),
('Suporte para Celular', 'Suporte Veicular Magnético para Celular', 34.99, 300, '2024-02-16 10:15:00'),
('Organizador de Mesa', 'Organizador de Mesa com 3 gavetas, madeira', 89.99, 80, '2024-02-17 15:00:00'),
('Apoio de Pulso Teclado', 'Apoio de Pulso em Gel para Teclado, Preto', 44.99, 150, '2024-02-18 12:45:00'),
('Filtro de Linha', 'Filtro de Linha Force 5 tomadas, com USB', 79.99, 200, '2024-02-19 09:30:00'),
('No-break SMS 700VA', 'No-break SMS 700VA, Bivolt, 4 tomadas', 399.99, 45, '2024-02-20 14:00:00'),
('Antena Wi-Fi Interna', 'Antena Wi-Fi 6dBi, SMA, para Placa de Rede', 29.99, 100, '2024-02-21 11:15:00'),
('Placa de Rede PCIe', 'Placa de Rede Gigabit Ethernet PCIe, Realtek', 49.99, 90, '2024-02-22 16:30:00'),
('Cabo DisplayPort 2m', 'Cabo DisplayPort 1.4, 8K, 60Hz, HDR', 69.99, 180, '2024-02-23 08:00:00'),
('Conversor VGA para HDMI', 'Conversor VGA para HDMI com Áudio, Ativo', 49.99, 120, '2024-02-24 13:45:00'),
('Extensor USB 5m', 'Cabo Extensor USB 3.0 Ativo 5m', 39.99, 150, '2024-02-25 10:30:00'),
('Switch 5 Portas Gigabit', 'Switch TP-Link TL-SG105, 5 Portas Gigabit', 129.99, 70, '2024-02-26 15:15:00'),
('Patch Cord CAT6 2m', 'Cabo de Rede CAT6 2m, Azul, 10 unidades', 79.99, 250, '2024-02-27 12:00:00'),
('Conector RJ45', 'Conector RJ45 Cat6, 100 unidades', 49.99, 200, '2024-02-28 09:45:00'),
('Ferram. Crimpar RJ45', 'Alicate Crimpador RJ45 para Cabo de Rede', 89.99, 60, '2024-02-29 14:30:00'),
('Testador de Cabo', 'Testador de Cabo de Rede RJ45/Telefone', 59.99, 80, '2024-03-01 11:00:00'),
('Suporte de Parede AP', 'Suporte para Access Point Teto/Parede', 29.99, 150, '2024-03-02 16:45:00'),
('Ventoinha 120mm', 'Ventoinha Corsair AF120, 120mm, LED Branco', 59.99, 200, '2024-03-03 08:30:00'),
('Controladora de Fans', 'Hub Controladora de Fans 10 portas, SATA', 79.99, 100, '2024-03-04 13:00:00'),
('Pasta Térmica Arctic', 'Pasta Térmica Arctic MX-4, 4g, Alta Condutividade', 59.99, 180, '2024-03-05 15:30:00'),
('Espátula Aplicação', 'Espátula de Silicone para Pasta Térmica', 9.99, 500, '2024-03-06 10:15:00'),
('Limpador de Tela', 'Spray Limpador de Tela 200ml + Microfibra', 24.99, 300, '2024-03-07 12:45:00'),
('Alcool Isopropílico', 'Alcool Isopropílico 1L, 99.9% Pureza', 39.99, 150, '2024-03-08 09:00:00'),
('Pincel Anti-estático', 'Pincel Anti-estático para Limpeza Eletrônica', 19.99, 200, '2024-03-09 14:15:00'),
('Ar Comprimido 200ml', 'Spray de Ar Comprimido para Limpeza, 200ml', 49.99, 100, '2024-03-10 11:30:00'),
('Pulseira Anti-estática', 'Pulseira Anti-estática com Cabo Terra', 29.99, 120, '2024-03-11 16:00:00'),
('Tapete Anti-estático', 'Tapete Anti-estático 60x40cm', 89.99, 50, '2024-03-12 08:45:00'),
('Crachá Magnético', 'Crachá Magnético para Fixação de Cabos', 14.99, 400, '2024-03-13 13:15:00'),
('Enforca Gatos 100mm', 'Enforca Gatos Nylon 100mm, 100 unidades', 19.99, 600, '2024-03-14 10:30:00'),
('Canaleta Adesiva', 'Canaleta Organizadora de Cabos 1m, Branca', 24.99, 200, '2024-03-15 15:45:00'),
('Spiral Cable Wrap', 'Tubo Espiral Organizador de Cabos, 3m', 29.99, 180, '2024-03-16 12:00:00'),
('Hub Thunderbolt 3', 'Hub Thunderbolt 3 com 2x HDMI, USB, Ethernet', 899.99, 30, '2024-03-17 09:30:00'),
('Docking Station USB-C', 'Docking Station USB-C 11 em 1, 4K HDMI', 599.99, 45, '2024-03-18 14:45:00'),
('Leitor de Cartão', 'Leitor Multileitor de Cartão de Memória USB 3.0', 49.99, 150, '2024-03-19 11:15:00'),
('Gravador DVD Externo', 'Gravador de DVD Externo USB 2.0, LG', 199.99, 40, '2024-03-20 16:30:00'),
('HD Case 2.5"', 'Case Externa para HD/SSD 2.5", USB 3.0', 59.99, 100, '2024-03-21 08:00:00'),
('Suporte SSD M.2', 'Suporte Adaptador PCIe para SSD M.2 NVMe', 129.99, 60, '2024-03-22 13:45:00'),
('Dissipador SSD M.2', 'Dissipador de Calor para SSD M.2, Alumínio', 39.99, 120, '2024-03-23 10:15:00'),
('Pasta Térmica Líquida', 'Pasta Térmica Líquida Conductonaut, 1g', 89.99, 50, '2024-03-24 15:00:00'),
('Termal Pad 1mm', 'Thermal Pad 1mm, 100x100mm, 6W/mK', 49.99, 80, '2024-03-25 12:30:00'),
('Parafusos M.2', 'KIT Parafusos M.2 com Chave, 10 unidades', 24.99, 300, '2024-03-26 09:45:00'),
('Espaçadores Placa-mãe', 'KIT Espaçadores Placa-mãe com Parafusos', 19.99, 250, '2024-03-27 14:15:00'),
('Organizador de Parafusos', 'Caixa Organizadora 24 compartimentos', 39.99, 100, '2024-03-28 11:00:00'),
('Lupa com LED', 'Lupa de Bancada 10x com LED', 59.99, 70, '2024-03-29 16:45:00'),
('Kit Chaves Torx', 'Kit 6 Chaves Torx T5-T15 para Eletrônicos', 34.99, 120, '2024-03-30 08:30:00'),
('Espátula Plástica', 'Kit 3 Espátulas Plásticas para Abertura', 19.99, 200, '2024-03-31 13:00:00'),
('Ventosa para Celular', 'Ventosa para Abertura de Celular/Tablet', 9.99, 300, '2024-04-01 15:30:00'),
('Palheta Abridora', 'Palheta Abridora de Plástico, 10 unidades', 14.99, 400, '2024-04-02 10:45:00'),
('Bandeja Magnética', 'Bandeja Magnética para Parafusos 15x10cm', 29.99, 150, '2024-04-03 12:15:00'),
('Estação de Solda', 'Estação de Solda 60W com Controle Digital', 249.99, 40, '2024-04-04 09:00:00'),
('Multímetro Digital', 'Multímetro Digital True RMS, Capa 2000', 159.99, 55, '2024-04-05 14:30:00'),
('Fonte Bancada', 'Fonte de Bancada 30V 5A, Digital', 399.99, 25, '2024-04-06 11:45:00'),
('Osciloscópio Portátil', 'Osciloscópio Digital Portátil 2 canais 100MHz', 1299.99, 15, '2024-04-07 16:00:00'),
('Gerador de Sinais', 'Gerador de Funções DDS 60MHz', 899.99, 20, '2024-04-08 08:15:00');

-- ============================================
-- INSERINDO PEDIDOS E ITENS (dados mais realistas)
-- ============================================

-- Inserindo 50 pedidos com status variados
INSERT INTO orders (user_id, status, total, created_at) VALUES
(1, 'DELIVERED', 3998.97, '2024-02-01 10:00:00'),
(2, 'DELIVERED', 6799.98, '2024-02-03 14:30:00'),
(3, 'SHIPPED', 1299.99, '2024-02-05 09:15:00'),
(4, 'DELIVERED', 899.99, '2024-02-07 16:45:00'),
(5, 'PROCESSING', 3499.99, '2024-02-09 11:00:00'),
(6, 'DELIVERED', 2549.98, '2024-02-11 13:30:00'),
(7, 'CANCELLED', 399.99, '2024-02-13 08:00:00'),
(8, 'DELIVERED', 1299.99, '2024-02-15 17:15:00'),
(9, 'PENDING', 1999.99, '2024-02-17 10:45:00'),
(10, 'DELIVERED', 499.99, '2024-02-19 12:00:00'),
(11, 'SHIPPED', 899.99, '2024-02-21 09:30:00'),
(12, 'DELIVERED', 3499.99, '2024-02-23 15:20:00'),
(13, 'PROCESSING', 249.99, '2024-02-25 11:45:00'),
(14, 'DELIVERED', 4299.99, '2024-02-27 14:10:00'),
(15, 'CONFIRMED', 1299.99, '2024-02-29 08:30:00'),
(16, 'DELIVERED', 289.99, '2024-03-02 16:00:00'),
(17, 'SHIPPED', 199.99, '2024-03-04 13:45:00'),
(18, 'DELIVERED', 1599.99, '2024-03-06 10:15:00'),
(19, 'PENDING', 399.99, '2024-03-08 15:30:00'),
(20, 'DELIVERED', 2499.99, '2024-03-10 12:45:00'),
(21, 'PROCESSING', 129.99, '2024-03-12 09:00:00'),
(22, 'DELIVERED', 899.99, '2024-03-14 17:30:00'),
(23, 'CONFIRMED', 459.99, '2024-03-16 11:15:00'),
(24, 'DELIVERED', 299.99, '2024-03-18 14:45:00'),
(25, 'CANCELLED', 79.99, '2024-03-20 08:45:00'),
(26, 'DELIVERED', 699.99, '2024-03-22 16:30:00'),
(27, 'SHIPPED', 399.99, '2024-03-24 10:00:00'),
(28, 'DELIVERED', 1299.99, '2024-03-26 13:15:00'),
(29, 'PROCESSING', 249.99, '2024-03-28 15:45:00'),
(30, 'DELIVERED', 3499.99, '2024-03-30 09:45:00'),
(31, 'PENDING', 1600.00, '2024-04-01 12:30:00'),
(32, 'DELIVERED', 499.99, '2024-04-03 14:00:00'),
(33, 'CONFIRMED', 1299.99, '2024-04-05 09:15:00'),
(34, 'DELIVERED', 289.99, '2024-04-07 11:30:00'),
(35, 'PROCESSING', 1999.99, '2024-04-09 16:45:00'),
(36, 'DELIVERED', 399.99, '2024-04-11 08:00:00'),
(37, 'SHIPPED', 2499.99, '2024-04-13 13:30:00'),
(38, 'DELIVERED', 199.99, '2024-04-15 15:45:00'),
(39, 'PENDING', 799.99, '2024-04-17 10:00:00'),
(40, 'DELIVERED', 1299.99, '2024-04-19 12:30:00'),
(41, 'CANCELLED', 299.99, '2024-04-21 09:00:00'),
(42, 'DELIVERED', 4299.99, '2024-04-23 16:15:00'),
(43, 'PROCESSING', 899.99, '2024-04-25 11:45:00'),
(44, 'DELIVERED', 2499.99, '2024-04-27 14:30:00'),
(45, 'SHIPPED', 459.99, '2024-04-29 08:15:00'),
(46, 'DELIVERED', 1299.99, '2024-05-01 13:00:00'),
(47, 'CONFIRMED', 399.99, '2024-05-03 15:30:00'),
(48, 'DELIVERED', 1999.99, '2024-05-05 10:45:00'),
(49, 'PENDING', 289.99, '2024-05-07 14:00:00'),
(50, 'PROCESSING', 3499.99, '2024-05-09 09:30:00');

-- ============================================
-- INSERINDO ITENS DOS PEDIDOS
-- ============================================
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES
(1, 1, 1, 3499.99), (1, 5, 2, 249.99),  -- Total: 3999.97
(2, 2, 1, 4299.99), (2, 4, 3, 499.99), (2, 6, 1, 299.99), -- Total: 6799.95
(3, 3, 1, 1299.99), (3, 7, 2, 289.99), -- Total: 1879.97
(4, 20, 1, 899.99), (4, 15, 1, 249.99), -- Total: 1149.98
(5, 1, 1, 3499.99), (5, 8, 3, 199.99), -- Total: 4099.96
(6, 2, 1, 4299.99), (6, 9, 1, 2499.99), -- Total: 6799.98 (mas com outro produto)
(7, 4, 1, 499.99), (7, 5, 1, 249.99), -- Total: 749.98
(8, 3, 1, 1299.99), (8, 8, 2, 199.99), -- Total: 1699.97
(9, 1, 1, 3499.99), (9, 4, 1, 499.99), -- Total: 3999.98
(10, 4, 1, 499.99), (10, 5, 1, 249.99), -- Total: 749.98
(11, 20, 1, 899.99), (11, 6, 1, 299.99), -- Total: 1199.98
(12, 1, 1, 3499.99), (12, 7, 1, 289.99), -- Total: 3789.98
(13, 5, 1, 249.99), (13, 8, 1, 199.99), -- Total: 449.98
(14, 2, 1, 4299.99), (14, 15, 1, 249.99), -- Total: 4549.98
(15, 3, 1, 1299.99), (15, 4, 1, 499.99), -- Total: 1799.98
(16, 7, 1, 289.99), (16, 5, 1, 249.99), -- Total: 539.98
(17, 5, 1, 249.99), (17, 8, 1, 199.99), -- Total: 449.98
(18, 18, 1, 1599.99), (18, 6, 1, 299.99), -- Total: 1899.98
(19, 4, 1, 499.99), (19, 5, 1, 249.99), -- Total: 749.98
(20, 9, 1, 2499.99), (20, 8, 2, 199.99), -- Total: 2899.97
(21, 13, 1, 79.99), (21, 15, 1, 249.99), -- Total: 329.98
(22, 20, 1, 899.99), (22, 5, 2, 249.99), -- Total: 1399.97
(23, 11, 1, 459.99), (23, 10, 1, 399.99), -- Total: 859.98
(24, 6, 1, 299.99), (24, 4, 1, 499.99), -- Total: 799.98
(25, 13, 1, 79.99), (25, 16, 1, 199.99), -- Total: 279.98
(26, 19, 1, 699.99), (26, 5, 1, 249.99), -- Total: 949.98
(27, 10, 1, 399.99), (27, 8, 1, 199.99), -- Total: 599.98
(28, 3, 1, 1299.99), (28, 15, 1, 249.99), -- Total: 1549.98
(29, 5, 1, 249.99), (29, 16, 1, 199.99), -- Total: 449.98
(30, 1, 1, 3499.99), (30, 4, 1, 499.99), -- Total: 3999.98
(31, 1, 1, 3499.99), (31, 4, 1, 499.99), (31, 5, 1, 249.99), -- Total: 4249.97
(32, 4, 1, 499.99), (32, 6, 1, 299.99), -- Total: 799.98
(33, 3, 1, 1299.99), (33, 5, 2, 249.99), -- Total: 1799.97
(34, 7, 1, 289.99), (34, 8, 1, 199.99), -- Total: 489.98
(35, 1, 1, 3499.99), (35, 2, 1, 4299.99), -- Total: 7799.98
(36, 4, 1, 499.99), (36, 10, 1, 399.99), -- Total: 899.98
(37, 9, 1, 2499.99), (37, 11, 1, 459.99), -- Total: 2959.98
(38, 5, 1, 249.99), (38, 17, 1, 199.99), -- Total: 449.98
(39, 22, 1, 799.99), (39, 6, 1, 299.99), -- Total: 1099.98
(40, 3, 1, 1299.99), (40, 21, 1, 129.99), -- Total: 1429.98
(41, 6, 1, 299.99), (41, 5, 2, 249.99), -- Total: 799.97
(42, 2, 1, 4299.99), (42, 1, 1, 3499.99), -- Total: 7799.98
(43, 20, 1, 899.99), (43, 4, 1, 499.99), -- Total: 1399.98
(44, 9, 1, 2499.99), (44, 17, 1, 199.99), -- Total: 2699.98
(45, 11, 1, 459.99), (45, 10, 1, 399.99), -- Total: 859.98
(46, 3, 1, 1299.99), (46, 6, 2, 299.99), -- Total: 1899.97
(47, 4, 1, 499.99), (47, 20, 1, 899.99), -- Total: 1399.98
(48, 1, 1, 3499.99), (48, 8, 1, 199.99), -- Total: 3699.98
(49, 7, 1, 289.99), (49, 13, 1, 79.99), -- Total: 369.98
(50, 1, 1, 3499.99), (50, 10, 1, 399.99); -- Total: 3899.98

-- ============================================
-- CONSULTAS PARA VERIFICAR OS DADOS
-- ============================================

-- 1. Ver total de registros inseridos
SELECT 'Total de Usuários' as Tabela, COUNT(*) as Quantidade FROM users
UNION ALL
SELECT 'Total de Produtos', COUNT(*) FROM products
UNION ALL
SELECT 'Total de Pedidos', COUNT(*) FROM orders
UNION ALL
SELECT 'Total de Itens', COUNT(*) FROM order_items;

-- 2. Top 5 produtos mais vendidos
SELECT
    p.id,
    p.name as produto,
    SUM(oi.quantity) as total_vendido,
    p.stock as estoque_atual
FROM products p
JOIN order_items oi ON p.id = oi.product_id
GROUP BY p.id, p.name, p.stock
ORDER BY total_vendido DESC
LIMIT 5;

-- 3. Status dos pedidos
SELECT
    status,
    COUNT(*) as quantidade,
    ROUND(AVG(total), 2) as valor_medio,
    SUM(total) as valor_total
FROM orders
GROUP BY status
ORDER BY quantidade DESC;

-- 4. Top 5 clientes que mais compraram
SELECT
    u.id,
    u.name as cliente,
    COUNT(o.id) as total_pedidos,
    SUM(o.total) as total_gasto
FROM users u
JOIN orders o ON u.id = o.user_id
GROUP BY u.id, u.name
ORDER BY total_gasto DESC
LIMIT 5;

-- 5. Últimos 10 pedidos realizados
SELECT
    o.id as pedido_id,
    u.name as cliente,
    o.status,
    o.total,
    DATE(o.created_at) as data_pedido
FROM orders o
JOIN users u ON o.user_id = u.id
ORDER BY o.created_at DESC
LIMIT 10;