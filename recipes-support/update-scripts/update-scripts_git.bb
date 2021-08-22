LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SUMMARY = "Scripts for upgrade"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/mera-company/upgrade_server;protocol=https" 

PV = "0.1.0-9+git${SRCPV}"
SRCREV = "524e9efd5bb2ecdf417c4eb0afaaae7866477f11"

S = "${WORKDIR}/git"

SRC_URI += "file://local_upgrade_server.service"

#inherit setuptools3
RDEPENDS_${PN} += "ssh python3-werkzeug python3-websocket-client python3-core python3 python3-pip python3-dbus python3-flask"

REQUIRED_DISTRO_FEATURES= "systemd"
SYSTEMD_SERVICE_${PN} = "local_upgrade_server.service"

inherit systemd 

FILES_${PN} += "/usr/bin/*"

do_install () {
        install -d  ${D}${bindir}/upgrade-server
        install -m 0777 ${S}/server/* ${D}${bindir}/upgrade-server

        install -d ${D}${systemd_unitdir}/system/
        install -m 0644 ${WORKDIR}/local_upgrade_server.service ${D}${systemd_unitdir}/system/
        sed -i -e 's!@BINDIR@!${bindir}!g' ${D}${systemd_unitdir}/system/local_upgrade_server.service
}
