package com.kartik.tickets.services;

import com.kartik.tickets.domain.entities.QrCode;
import com.kartik.tickets.domain.entities.Ticket;

public interface QrCodeService {

    QrCode generateQrCode(Ticket ticket);

}
