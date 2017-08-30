import { platformBrowser } from '@angular/platform-browser';
import { ProdConfig } from './blocks/config/prod.config';
import { DevItWithGregWebSiteAppModuleNgFactory } from '../../../../build/aot/src/main/webapp/app/app.module.ngfactory';

ProdConfig();

platformBrowser().bootstrapModuleFactory(DevItWithGregWebSiteAppModuleNgFactory)
.then((success) => console.log(`Application started`))
.catch((err) => console.error(err));
