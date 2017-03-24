

<?php $this->load->view('global/header');?>
	
	<div id="global">
	<div id="content">
		<h3>Bienvenue, <span class="pseudo"><?php echo $this->session->userdata('pseudo'); ?></span></h3> 
		
		<p>
			<b><i>«Avec PPD, la sérénité à votre portée» </b></i> </br></br>
			<!--Une fois installé, notre dispositif comprenant une caméra et un détecteur infrarouge, détectera toute intrusion dans votre domicile. </br>
			Vous serez alors prévenu instantanément par un e-mail envoyé sur votre boite de messagerie.</br>
			Connectez vous alors, à l'aide de vos identifiants personnels afin de visualiser en temps réel l'état de votre domicile. </br>
			De plus, en vous procurant l'application android vous pourrez intéragir avec le système en temps réel.-->
		</p>
		
		<div class="impair">
			<img src="<?php echo(base_url().'assets/images/camera.png')?>" alt="camera" />
			<b>Etape 1 :</b> Installez notre dispositif de sécurité. 
		</div></br>
	
		<div class="pair">
			<img src="<?php echo(base_url().'assets/images/maison.png')?>" alt="maison" />
			<b>Etape 2 :</b> Quittez sereinement votre domicile.
		</div></br>
		
		<div class="impair">
			<img src="<?php echo(base_url().'assets/images/alert.png')?>" alt="alerte" />
			<b>Etape 3 :</b> Recevez une alerte en cas d'intrusion.  
		</div></br>
		
		<div class="pair">
			<img src="<?php echo(base_url().'assets/images/computer.png')?>" alt="computer" />
			<b>Etape 4 :</b> Connectez-vous à votre espace sécurisé.  
		</div></br>
		
			<div class="impair">
			<img src="<?php echo(base_url().'assets/images/loupe.png')?>" alt="loupe" />
			<b>Etape 5 :</b> Accéder en direct à votre caméra et observez.  
		</div></br>
	</div>
	
		
	<div id="barre">
		<a href="<?php echo(base_url().'assets/images/carte1_grande.png')?>" data-lightbox="galerie"><img src="<?php echo(base_url().'assets/images/carte1.png')?>" alt="raspberry" /> </a> </br>
		<a href="<?php echo(base_url().'assets/images/carte2_grande.png')?>" data-lightbox="galerie"><img src="<?php echo(base_url().'assets/images/carte2.png')?>" alt="arduino" /> </a> </br>
		<a href="<?php echo(base_url().'assets/images/poster_grand.png')?>" data-lightbox="galerie"><img src="<?php echo(base_url().'assets/images/poster.png')?>" alt="poster" /> </a> </br>
			
		<p> 
			<b>- Mars 2014 -</b> </br> </br>
			Benjamin Dauphin </br>
			Olivier Vanel </br>
			Sophie Ferrand </br>
			Romaric Marion </br>
			Gaïd Kannengiesser </br>
			Kévin Vu </br></br>
			<span id="mailto">
				<b><?php echo mailto('vanel.pro@gmail.com', 'Nous joindre') ?></b>
				<a href="mailto:vanel.pro@gmail.com"> <img src="<?php echo(base_url().'assets/images/enveloppe1.png')?>" alt="enveloppe" /> </a>
			</span>
		</p>
	</div>
	
	</div>

		
<?php $this->load->view('global/footer');?>