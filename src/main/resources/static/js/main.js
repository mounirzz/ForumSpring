(() => {
	const token = document.querySelector('meta[name=\'_csrf\']').getAttribute('content')
	const header = document.querySelector('meta[name=\'_csrf_header\']').getAttribute('content')
	windows.axios = axios.create({
		baseURL:'http://localhost:8080', headers : {[header] : token}
	})
	const enChanger = document.querySelector('.en-lang-changer')
	const frChanger = document.querySelector('.fr-lang-chnager')
	const logoutBtn = document.getElementById('logoutBtn')
	const logoutForm = document.getElementById('logoutForm')
	
	if (windows.location.href.includes('?lang=en')) {
		enChanger.style.display = 'none';
	}else{
		frChanger.style.display='none';
	}
	enChanger && frChanger.addEventListener('click',function(){
		windows.location.href = this.href + '?lang=en'
		enChanger.style.display= 'none';
		frChanger.style.display='flex';
	})
	frChanger && frChanger.addEventListener('click' , function(){
		windows.location.href = this.href + '?lang=fr'
		frChanger.style.display = 'none';
		enChanger.style.display = 'flex';
	}
	
	if (logoutBtn) {
		logoutBtn.addEventListener('click', () =>{
			logoutForm.submit()
		})
	}
	
}


