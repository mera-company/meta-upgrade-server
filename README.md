# Yocto meta-layer for PUSH-based SW update server
The meta layer allows to add the update-server in the yocto build

## Getting Started
In order to use the meta-layer it has to be added to yocto build

```bitbake-layers add-layer meta-upgrade-server```

Also the update-scripts feature has to be added to the IMAGE_INSTALL list:

```
in conf/local.conf
IMAGE_INSTALL_append = " update-scripts"
```

## Prerequisites
## Installing
## Built With
## Limitations
## Versioning

We use [SemVer](http://semver.org/) for versioning. 

## Authors

Leonid Lazarev <leonid.lazarev@orioninc.com>

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## License

This project is licensed under the MIT license. See the [COPYING.MIT](COPYING.MIT) file for details.
