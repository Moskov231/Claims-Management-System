import { Injectable } from '@angular/core';

interface HospitalDetail {
  id: string;
  name: string;
  location: string;
}

interface PoilcyDetail {
  id: string;
  name: string;
}

interface BenefitDetail {
  id: string;
  name: string;
}

@Injectable({
  providedIn: 'root',
})
export class SelectDetailService {
  public hospitalDetails: Array<HospitalDetail> = [
    { id: 'H100', name: 'Apollo Hospital', location: 'Rajahmundry' },
    { id: 'H200', name: 'Care Hospital', location: 'Vizag' },
    {id: 'H300', name: 'Gayathri Hospital', location: 'Vijayawada',},
    {id: 'H400', name: 'Varun Hospitals', location: 'Amaravathi',},

  ];

  public policyDetails: Array<PoilcyDetail> = [
    { id: 'P100', name: 'Normal Health Policy' },
    { id: 'P200', name: 'Premium Health Policy' },
    { id: 'P300', name: 'Super Premium Health Policy' },
  ];

  public benefitDetails: Array<BenefitDetail> = [
    { id: 'B101', name: 'Coverage for Omicron' },
    { id: 'B102', name: 'Coverage for Dental' },
    { id: 'B103', name: 'Medical Tests covered' },
    { id: 'B104', name: 'Hospital Room charges covered' },
    { id: 'B107', name: 'Health Policy for rare diseases' },
    {id: 'B108',name: 'New Bron Action Plan Policy'},
  ];
}
