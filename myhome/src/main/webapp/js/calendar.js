/*
* calendar.js
*/
document.addEventListener("DOMContentLoaded", initForm);

function initForm() {
	let show = document.querySelector('#show');
	show.appendChild(svc.makeTable());
	document.querySelector('#show>table')//
		.appendChild(svc.makeHeader2());
	document.querySelector('#show>table')//
		.appendChild(svc.makeBody(6));
}

const svc = {
	makeTable: function() {
		let tbl = document.createElement('table');
		tbl.setAttribute('border', "2");
		return tbl;
	},
	makeHeader: function() {
		const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
		let thd = document.createElement('thead');
		let tr = document.createElement('tr');
		days.forEach((day) => {
			let th = document.createElement('th');
			th.innerHTML = day;
			tr.appendChild(th);
		});
		thd.appendChild(tr);
		return thd;
	},
	makeHeader2: function() {
		const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
		let tr = days.reduce((acc, curVal) => {
			let th = document.createElement('th');
			th.innerHTML = curVal;
			acc.appendChild(th);
			return acc;
		}, document.createElement('tr')); // <tr><th/>*7</tr>
		let thd = document.createElement('thead');
		thd.appendChild(tr);

		return thd;
	},
	makeBody: function(month = 5) {
		let tbd = document.createElement('tbody');
		let tr = document.createElement('tr');
		let spaces = this.getFirstDate(month)// => 1일의 위치.
		for (let i = 0; i < spaces; i++) {
			let td = document.createElement('td');
			td.innerHTML = " ";
			tr.appendChild(td);
		}
		// 날짜 출력해주는 부분.
		for (let d = 1; d <= this.getLastDate(month); d++) { // getLastDate(month) => 월의 마지마날을 반환.
			let td = document.createElement('td');
			td.innerHTML = d;
			tr.appendChild(td);
			if ((d + spaces) % 7 == 0) {
				// 토요일이 끝나면 새로운 한주의 시작.
				tbd.appendChild(tr); // <tr><td/>*7</tr>
				tr = document.createElement('tr');
			}
		}
		tbd.appendChild(tr);
		return tbd;
	},
	getFirstDate(month) {
		switch (month) {
			case 5:
				return 3;
			case 6:
				return 6;
		}
	},
	getLastDate(month) {
		switch (month) {
			case 5:
				return 31;
			case 6:
				return 30;
		}
	}
} // end of svc.
