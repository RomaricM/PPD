<?php $this->load->view('global/header');?>
	
	<div id="content_video">
		<center>
			<h3>Historique des alertes</h3>
			
		
				<?php ?>


				<?php
					$this->table->set_heading('Numéro', 'Date', 'Heure');
					foreach($alertes as $alertes): 
						$this->table->add_row(array($alertes['NoAlerte'], $alertes['DateAlerte'], $alertes['HeureAlerte']));
					endforeach;
					echo $this->table->generate();
				?>


				

			
		</center>
	</div>

<?php $this->load->view('global/footer');?>